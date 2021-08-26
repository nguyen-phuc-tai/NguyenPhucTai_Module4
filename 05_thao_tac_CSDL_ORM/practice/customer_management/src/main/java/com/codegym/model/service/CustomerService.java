package com.codegym.model.service;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer save(Customer customer);

    void add(Customer customer);

    boolean exists(Long id);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
