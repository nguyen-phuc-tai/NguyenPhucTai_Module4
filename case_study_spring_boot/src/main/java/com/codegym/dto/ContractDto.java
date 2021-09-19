package com.codegym.dto;

import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Services;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContractDto {
    private Long contractId;
    private String contractStartDate ;
    private String contractEndDate ;
    @Min(1)
    private Double contractDeposit;
    @Min(1)
    private Double contractTotalMoney;
    private List<ContractDetail> contractDetailSet;
    private Employee employee;
    private Customer customer;
    private Services services;
}