package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.entity.User;
import com.codegym.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class FormController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/index";
    }

    @PostMapping(value = "/")
    public String result(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, Model model) {

        Optional<User> users =userService.findAllByEmail(userDto.getEmail());
        if(users.isPresent()){
            model.addAttribute("msg","email đã tồn tại");
            return "/index";
        }
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            return "/result";
        }
    }
}