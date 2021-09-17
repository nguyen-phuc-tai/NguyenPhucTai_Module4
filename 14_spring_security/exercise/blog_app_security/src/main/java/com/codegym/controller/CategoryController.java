package com.codegym.controller;

import com.codegym.model.entity.Category;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService cateloryService;

    @GetMapping(value = "/")
    public String showListCatelory(Model model){
        model.addAttribute("categoryList", cateloryService.findAll());
        return "category/list";
    }
    @GetMapping(value = "/catelory-create")
    public String showCreateCatelory(Model model){
        model.addAttribute("category",new Category());
        return "category/create";

    }

    @PostMapping(value = "/category-create/create")
    public String createCatelory(@ModelAttribute Category category){
        this.cateloryService.save(category);
        return "redirect:/category";
    }
    @GetMapping(value = "/category-edit/edit")
    public String showEditCatelory(@RequestParam int id, Model model){
        model.addAttribute("category",this.cateloryService.findById(id));
        model.addAttribute("categoryList",this.cateloryService.findAll());
        return "category/edit";
    }
    @PostMapping(value = "/category-edit/edit")
    public String editCatelory(@ModelAttribute Category category){
        this.cateloryService.update(category);
        return "redirect:/category";
    }
    @GetMapping(value = "/category-delete/delete")
    public String deleteCatelory(@RequestParam int id){
        this.cateloryService.delete(id);
        return "redirect:/category";
    }

}
