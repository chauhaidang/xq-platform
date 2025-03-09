package com.xq.testplan.service;

import com.xq.testplan.dto.CustomerDto;

public interface ITestPlanService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
