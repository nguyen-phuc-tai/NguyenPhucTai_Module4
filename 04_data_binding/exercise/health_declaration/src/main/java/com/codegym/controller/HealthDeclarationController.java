package com.codegym.controller;

import com.codegym.model.bean.People;
import com.codegym.model.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/peoples")
public class HealthDeclarationController {

    @Autowired
    private IPeopleService peopleService;

    @GetMapping(value = "/list")
    public ModelAndView showList() {

        ModelAndView modelAndView = new ModelAndView("/list");
        List<People> peoples = peopleService.findAll();
        modelAndView.addObject("peoples", peoples);
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        People peoples = peopleService.findOne(id);
        model.addAttribute("peoples",peoples);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("people") People people, RedirectAttributes redirectAttributes){
        peopleService.save(people);
        redirectAttributes.addFlashAttribute("msg","Success!!");
        return "redirect:/peoples/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("people",new People());
        return "create";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute("people") People people, RedirectAttributes redirectAttributes, Model model){
        peopleService.save(people);
        redirectAttributes.addFlashAttribute("msg","Success!!");
        return "redirect:/peoples/list";
    }
}
