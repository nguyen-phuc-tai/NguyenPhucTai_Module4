package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.service.IBlogService;
import com.codegym.model.service.ICateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICateloryService cateloryService;

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
        model.addAttribute("cateloryList",cateloryService.findAll());
        return "blog/create";
    }
    @PostMapping(value = "/blog-create")
    public String createBlog(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping(value = "/edit-blog/edit")
    public String showEditBlog(@RequestParam int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        model.addAttribute("cateloryList",this.cateloryService.findAll());
        return "blog/edit";
    }
    @PostMapping(value = "/blog-edit")
    public String editBlog(@ModelAttribute Blog blog){
        this.blogService.update(blog);
        Date date = new Date(System.currentTimeMillis());
        blog.setDateBlog(date);
        return "redirect:/";
    }
    @GetMapping(value = "/view-blog/view")
    public String showViewBlog(@RequestParam int id,Model model){
        model.addAttribute("blog", this.blogService.findById(id));
        return "blog/view";
    }
    @GetMapping(value = "/delete-blog/view")
    public String deleteBlog(@RequestParam int id){
        this.blogService.delete(id);
        return "redirect:/";
    }
}
