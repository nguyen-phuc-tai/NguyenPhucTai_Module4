package com.codegym.cms.model.service.impl;


import com.codegym.cms.model.entity.Customer;
import com.codegym.cms.model.repository.ICustomerRepository;
import com.codegym.cms.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}
