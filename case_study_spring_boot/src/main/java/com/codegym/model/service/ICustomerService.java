package com.codegym.model.service;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {



    Page<Customer> search(Pageable pageable, @Param("customerName") String customerName,@Param("customerType") String customerType);

    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);


    void save(Customer customer);

    void remove(Long id);

    List<CustomerType> findAllCustomerType();

    Optional<Customer> findAllByEmail(String email);

}