package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String showProduct(Model model) {
        List<Product> productList =productService.findAll();
        model.addAttribute("products", productList);
        return "list";
    }
    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.update(product);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }
    @GetMapping("/search")
    public String searchNameProduct(@RequestParam(name = "search-name",required = false) String search, Model model) {
        model.addAttribute("products", productService.findByName(search));
        return "list";
    }

}
