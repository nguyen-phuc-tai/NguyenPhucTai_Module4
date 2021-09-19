package com.codegym.dto;

import com.codegym.model.entity.customer.CustomerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
public class CustomerDto {
    public final String DATE="^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
    private Long customerId;
    @NotBlank(message = "Please input name")
    private String name;
    @NotBlank
    @Column(columnDefinition = "DATE")
    @NotBlank(message = "Please fill out the form")
    private String birthday;
    @NotBlank(message = "Please fill out the form")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Not valid (KH-xxxx)")
    private String customerCode;
    @NotBlank
    private String gender;
    @NotBlank
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Id Card not valid (9 or 12 number)")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Telephone not valid " +
            "(090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx)")

    private String phone;
    @Email
    private String email;
    @NotBlank(message = "Please fill out the form")
    private String address;
    private CustomerType customerType ;


}