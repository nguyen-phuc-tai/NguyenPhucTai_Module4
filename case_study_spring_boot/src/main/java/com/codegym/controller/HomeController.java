package com.codegym.controller;


import com.codegym.model.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


@Controller
public class HomeController {
    @GetMapping
    public String showHome(Principal principal, Model model) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
        }
        return "/home";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping(value = "/403")
    public String goError(){
        return "403Page";
    }
}