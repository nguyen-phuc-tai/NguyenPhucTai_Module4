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
    @NotBlank(message = "Tên dịch vụ không được để trống")
    private  String serviceName;
    @NotBlank(message = "Mã dịch vụ không được để trống")
    @Pattern(regexp = "^DV-[0-9]{4}",  message = "Mã dịch vụ phải đúng định dạng DV-xxxx")
    private  String serviceCode;
    @Min(value = 1,message = "Diện tích phải lớn hơn 0")
    private int serviceArea;
    @Min(value = 1,message = "Giá dịch vụ phải lớn hơn 0")
    @NotBlank(message = "Giá dịch vụ không được để trống")
    private double serviceCost;
    @Min(value = 1,message = "Số người phải là số dương lớn hơn 0")
    @NotBlank(message = "Vui lòng nhập số người tối đa!")
    private int serviceMaxPeople;
    @NotBlank(message = "Tiêu chuẩn phòng không được để trống")
    private String standardRoom;
    @NotBlank(message = "Vui lòng nhập mô tả")
    private String descriptionOtherConvenience;
    @Min(value = 1,message = "Diện tích hồ bơi phải lớn hơn 0!")
    @NotBlank(message = "Diện tích hồ bơi không được để trống!")
    private  double poolArea;
    @Min(value = 1,message = "Số tầng phải là số dương lớn hơn 0!")
    @NotBlank(message = "Vui lòng nhập số tầng")
    private int numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;

}