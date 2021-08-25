package com.codegym.controller;

import com.codegym.model.bean.People;
import com.codegym.model.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/peoples")
public class HealthDeclarationController {

    @Autowired
    private IPeopleService peopleService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("people",new People());
        return "create";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute("people") People people, RedirectAttributes redirectAttributes){
        peopleService.save(people);
        redirectAttributes.addFlashAttribute("msg","Success!!");
        return "redirect:/peoples";
    }
}
