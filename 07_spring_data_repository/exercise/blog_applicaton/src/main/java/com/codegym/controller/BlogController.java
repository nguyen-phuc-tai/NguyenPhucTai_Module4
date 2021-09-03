package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.entity.Category;
import com.codegym.model.service.blog.IBlogService;
import com.codegym.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping({"", "/list"})
    public String list(@PageableDefault(value = 4, sort = "createStartTime",  direction = Sort.Direction.DESC)
                                   Pageable pageable,
                       @RequestParam Optional<String> name, @RequestParam Optional<Integer> idCategory, Model model) {
        String keywordValue = "";
        Integer idCategoryValue = null;
        Page<Blog> blogList = null;
        if (idCategory.isPresent()) {
            idCategoryValue = idCategory.get();
            blogList = iBlogService.findAllByCategoryId(idCategoryValue, pageable);
        } else if (name.isPresent()) {
            keywordValue = name.get();
            blogList = iBlogService.findAllByNameContrains(keywordValue, pageable);
        } else {
            blogList = iBlogService.findAll(pageable);
        }

        model.addAttribute("keywordValue", keywordValue);
        model.addAttribute("idCategoryValue", idCategoryValue);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis()));
        blog.setCreateStartTime(time);
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msgSuccess", "Added new blog have successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msgSuccess", "Added new blog have successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.delete(blog.getId());
        redirect.addFlashAttribute("msgSuccess", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/view";
    }

}