package com.codegym.controller;

import com.codegym.model.entity.Category;
import com.codegym.model.service.blog.IBlogService;
import com.codegym.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String list(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Category> categories = iCategoryService.findAll(pageable);
        model.addAttribute("categories", categories);
        return "category/list";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping({"/save","/update"})
    public String save(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("msgSuccess", "Added new category have successfully");
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        iCategoryService.delete(category.getId());
        redirect.addFlashAttribute("msgSuccess", "Removed category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/view")
    public String view(@PageableDefault(value = 5, sort = "createStartTime") Pageable pageable, @PathVariable int id, Model model) {
        model.addAttribute("idCategory", id);
        model.addAttribute("blogList", iBlogService.findAllByCategoryId(id,pageable));
        return "category/view";
    }
}