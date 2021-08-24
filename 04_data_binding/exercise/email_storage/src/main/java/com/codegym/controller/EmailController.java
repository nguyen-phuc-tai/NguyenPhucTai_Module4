package com.codegym.controller;

import com.codegym.model.SettingEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("setting", "settingEmail", new SettingEmail());
    }

    @PostMapping("/save-setting")
    public ModelAndView saveSetting(@ModelAttribute("settingEmail") SettingEmail settingEmail){
        return new ModelAndView("result");
    }
}
