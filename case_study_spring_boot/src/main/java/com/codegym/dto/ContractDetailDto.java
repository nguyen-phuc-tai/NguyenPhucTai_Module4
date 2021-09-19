package com.codegym.dto;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ContractDetailDto {
    private Long contractDetailId;
    @NotBlank(message = "Vui lòng nhập số lượng!")
    @Min(value = 1,message = "Số lượng phải là số dương lớn hơn 0!")
    private Integer quantity;
    private AttachService attachService;
    private Contract contract;

}