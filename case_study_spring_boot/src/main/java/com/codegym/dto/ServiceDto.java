package com.codegym.dto;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private  Long serviceId;
    @NotBlank(message = "Please fill out the form")
    private  String serviceName;
    @NotBlank(message = "Please fill out the form")
    @Pattern(regexp = "^DV-[0-9]{4}",  message = "Mã dịch vụ phải đúng định dạng DV-xxxx")
    private  String serviceCode;
    @Min(10)
    private int serviceArea;
    @Min(1)
    @NotNull(message = "Please fill out the form")
    private double serviceCost;
    @Min(1)
    @NotNull(message = "Please fill out the form")
    private int serviceMaxPeople;
    @NotBlank(message = "Please fill out the form")
    private String standardRoom;
    @NotBlank(message = "Please fill out the form")
    private String descriptionOtherConvenience;
    @Min(10)
    @NotNull
    private  double poolArea;
    @Min(1)
    @NotNull(message = "Please fill out the form")
    private int numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;

}