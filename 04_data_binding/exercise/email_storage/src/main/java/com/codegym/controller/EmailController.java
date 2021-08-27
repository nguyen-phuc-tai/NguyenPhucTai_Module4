package com.codegym.controller;

import com.codegym.model.bean.SettingEmail;
import com.codegym.model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<SettingEmail> emailList = emailService.findAll();
        modelAndView.addObject("emailList", emailList);
        return modelAndView;
    }


    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("emails",new SettingEmail());
        return "create";
    }

    @PostMapping("/save")
    public String saveSetting(@ModelAttribute("settingEmail") SettingEmail settingEmail, RedirectAttributes redirectAttributes){
        emailService.save(settingEmail);
        redirectAttributes.addFlashAttribute("msg","Success!!");
        return "redirect:/emails/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        SettingEmail settingEmails = emailService.findOne(id);
        model.addAttribute("settingEmails",settingEmails);
        return "edit";
    }

    @PostMapping("/edit")
    public String EditSetting(@ModelAttribute("settingEmail") SettingEmail settingEmail, RedirectAttributes redirectAttributes){
        emailService.save(settingEmail);
        redirectAttributes.addFlashAttribute("msg","Success!!");
        return "redirect:/emails/list";
    }
}
