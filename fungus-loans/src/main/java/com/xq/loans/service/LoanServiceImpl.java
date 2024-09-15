package com.xq.loans.service;

import com.xq.loans.dto.LoanDto;
import com.xq.loans.entity.Loan;
import com.xq.loans.exception.LoanAlreadyExistsException;
import com.xq.loans.exception.ResourceNotFoundException;
import com.xq.loans.mapper.LoanMapper;
import com.xq.loans.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class LoanServiceImpl implements ILoanService {

    private LoanRepository loanRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> found = loanRepository.findByMobileNumber(mobileNumber);
        if (found.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already exists with mobile number: " + mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoanDto(loan, new LoanDto());
    }

    @Override
    public boolean updateLoan(LoanDto loanDto) {
        Loan loan = loanRepository.findByLoanNumber(loanDto.getLoanNumber()).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "loanNumber", loanDto.getLoanNumber())
        );
        loan = LoanMapper.mapToLoan(loanDto, loan);
        loanRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loan.getLoanId());
        return true;
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan loan = new Loan();
        long randomLoanNum = 100000000000L + new Random().nextInt(900000000);
        loan.setMobileNumber(mobileNumber);
        loan.setLoanNumber(Long.toString(randomLoanNum));
        loan.setLoanType("HOME_LOAN");
        loan.setTotalLoan(5000);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(5000);
        return loan;
    }
}
