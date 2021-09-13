package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "http://localhost:63342")
public class BlogRestController {
    private static Integer number = 1;
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> showBlog(@RequestParam int page){
        Page<Blog> blogList = this.blogService.findAllBlog(PageRequest.of(page,1));
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping(value = "/search/{keyword}")
    public ResponseEntity<List<Blog>> searchByName(@PathVariable String keyword){
        List<Blog> blogList = this.blogService.findAllByName(keyword);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable Integer id){
        Optional<Blog> blogs = this.blogService.findById(id);
        if(!blogs.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs.get(), HttpStatus.OK);

    }
}
