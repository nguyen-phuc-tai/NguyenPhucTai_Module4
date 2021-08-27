package com.codegym.cms.model.service;

import com.codegym.cms.model.entity.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}