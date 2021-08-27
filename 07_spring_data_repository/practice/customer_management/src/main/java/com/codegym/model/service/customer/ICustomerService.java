package com.codegym.model.service.customer;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Province;
import com.codegym.model.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
