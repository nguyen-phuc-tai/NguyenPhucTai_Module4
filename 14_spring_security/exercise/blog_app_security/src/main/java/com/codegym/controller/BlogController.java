package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.entity.Category;
import com.codegym.model.service.IBlogService;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService cateloryService;

    @ModelAttribute("category")
    public List<Category> cateloryList(){
        return cateloryService.findAll();
    }

    @RequestMapping(value = "/")
    public ModelAndView showListBlog(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(name = "nameSearch")Optional<String>  nameSearch){
        String keywordValue = "";

        Page<Blog> blogPage;

        ModelAndView modelAndView = new ModelAndView("/blog/list");
        if(nameSearch.isPresent()){
            keywordValue = nameSearch.get();
        }
        blogPage = this.blogService.findAllByNameBlogContaining(keywordValue,pageable);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("blogList",blogPage);
        return modelAndView;
    }
    @GetMapping(value = "/create-blog/create")
    public String showCreateBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }
    @PostMapping(value = "/blog-create")
    public String createBlog(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping(value = "/edit-blog/edit")
    public String showEditBlog(@RequestParam int id,Model model){
        Optional<Blog> blog = blogService.findById(id);
        if(!blog.isPresent()){
            model.addAttribute("message","Find not found");
            return "blog/list";
        }
        model.addAttribute("blog",blog);
        return "blog/edit";
    }
    @PostMapping(value = "/blog-edit")
    public String editBlog(@ModelAttribute Blog blog){
        Date date = new Date(System.currentTimeMillis());
        blog.setDateBlog(date);
        this.blogService.update(blog);
        return "redirect:/";
    }
    @GetMapping(value = "/view-blog/view")
    public String showViewBlog(@RequestParam int id,Model model){
        Optional<Blog> blog = blogService.findById(id);
        if(!blog.isPresent()){
            model.addAttribute("message","Find not found");
            return "blog/list";
        }
        model.addAttribute("blog", blog);
        return "blog/view";
    }
    @GetMapping(value = "/delete-blog/view")
    public String deleteBlog(@RequestParam int id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if(!blog.isPresent()){
            model.addAttribute("message","Find not found");
            return "blog/list";
        }
        this.blogService.delete(id);
        return "redirect:/";
    }
}
