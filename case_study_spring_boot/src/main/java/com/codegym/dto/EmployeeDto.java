package com.codegym.dto;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.File;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    @NotBlank(message = "Please fill out the form")
    private String employeeName;
    @Column(columnDefinition = "DATE")
    @NotBlank(message = "Please fill out the form")
    private String employeeBirthday;
    @NotBlank
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Not valid (9 number or 12 number)")
    private String employeeIdCard;
    @NotBlank
    @Min(1)
    @NotNull(message = "Please fill out the form")
    private String employeeSalary;
    @NotBlank
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Telephone not valid " +
            "(090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx)")
    private String employeePhone;
    @NotNull(message = "Please fill out the form")
    @Email(message = "Email not valid")
    private String employeeEmail;
    @NotBlank(message = "Please fill out the form")
    private String employeeAddress;
    private Position position;
    private Division division;
    private EducationDegree educationDegree;
}