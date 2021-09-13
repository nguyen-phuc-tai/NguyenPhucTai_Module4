package com.codegym.model.serivce;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
}