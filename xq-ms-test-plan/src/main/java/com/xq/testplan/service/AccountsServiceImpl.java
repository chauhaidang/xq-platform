package com.xq.testplan.service;

import com.xq.testplan.constants.AccountsContants;
import com.xq.testplan.dto.AccountsDto;
import com.xq.testplan.dto.CustomerDto;
import com.xq.testplan.entity.Accounts;
import com.xq.testplan.entity.Customer;
import com.xq.testplan.exception.CustomerAlreadyExistsException;
import com.xq.testplan.exception.ResourceNotFoundException;
import com.xq.testplan.mapper.AccountsMapper;
import com.xq.testplan.mapper.CustomerMapper;
import com.xq.testplan.repository.AccountsRepository;
import com.xq.testplan.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class TestPlanServiceImpl implements ITestPlanService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        log.info("Creating account for customer {}", customerDto);
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> customerByMobileNum = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (customerByMobileNum.isPresent()) {
            throw new CustomerAlreadyExistsException(String.format(
                    "Customer already registered with given mobile number: %s", customerDto.getMobileNumber()));
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccount(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto account = customerDto.getAccount();
        if (account != null) {
            Accounts accountEntity = accountsRepository.findById(account.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", account.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(account, accountEntity);
            accountEntity = accountsRepository.save(accountEntity);

            Long customerId = accountEntity.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));
            CustomerMapper.mapToCustomer(customerDto, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Long customerId = customer.getCustomerId();
        accountsRepository.deleteByCustomerId(customerId);
        customerRepository.deleteById(customerId);
        return true;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());

        long randomAccNum = 1000000000L + new Random().nextInt(900000000);
        accounts.setAccountNumber(randomAccNum);
        accounts.setAccountType(AccountsContants.SAVINGS);
        accounts.setBranchAddress(AccountsContants.ADDRESS);
        return accounts;
    }
}
