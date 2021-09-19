package com.codegym.dto;

import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Services;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContractDto implements Validator {
    private Long contractId;
    @NotBlank(message = "Vui lòng chọn ngày làm hợp đồng!")
    private String contractStartDate ;
    @NotBlank(message = "Vui lòng chọn ngày kết thúc hợp đồng!")
    private String contractEndDate ;
    @NotBlank(message = "Vui lòng nhập tiền đặt cọc!")
    @Min(value = 1, message = "Tiền đặt cọc phải là số dương lớn hơn 0!")
    private Double contractDeposit;
    private Double contractTotalMoney;
    private List<ContractDetail> contractDetailSet;
    private Employee employee;
    private Customer customer;
    private Services services;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        try {
            Date contractStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.getContractStartDate());
            Date contractEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.getContractEndDate());
            if(contractEndDate.before(contractStartDate)){
                errors.rejectValue("contractEndDate", "",
                        "Ngày kết thúc  phải lớn hơn ngày bắt đầu");
            }        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}