package com.codegym.model.service.impl;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.repository.customer.ICustomerRepository;
import com.codegym.model.repository.customer.ICustomerTypeRepository;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private  ICustomerRepository customerRepository;

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;




    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }




    @Override
    public Page<Customer> search(Pageable pageable, String customerName, String customerType) {
        return customerRepository.search(pageable,"%" + customerName +"%", "%" + customerType + "%");
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<Customer> findAllByCustomerCode(String code) {
        return customerRepository.findAllByCustomerCode(code);
    }

    @Override
    public Optional<Customer> findAllByEmail(String email) {
        return customerRepository.findAllByEmail(email);
    }

    @Override
    public Optional<Customer> findAllByPhone(String phone) {
        return customerRepository.findAllByPhone(phone);
    }

    @Override
    public Optional<Customer> findAllByEmailOrPhoneOrCustomerCode(String email) {
        return Optional.empty();
    }
}