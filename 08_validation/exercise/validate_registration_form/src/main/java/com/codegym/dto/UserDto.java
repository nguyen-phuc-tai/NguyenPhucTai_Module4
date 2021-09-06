package com.codegym.dto;

import com.codegym.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
public class UserDto{
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Pattern(regexp = "(^$|[0-9]*$)",message = "Input number")
    private String phoneNumber;

    @Min(18)
    private int age;

    @Email
    private String email;

}
