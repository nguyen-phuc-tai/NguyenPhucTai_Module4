package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.model.entity.Item;
import com.codegym.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class ItemsController {

    @ModelAttribute("cart")
    public CartDto getCart() {
        return new CartDto();
    }

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String goToHomePage(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "item/home";
    }


    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "item/detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, Model model,
                            @SessionAttribute("cart") CartDto cartDto,
                            @RequestParam("action") String action) {
        Item item = itemService.findById(id);
        if (item == null) {
            return "error";
        }
        if (action.equals("add")) {
            cartDto.addItem(item);
            return "redirect:/cart";
        }
        if (action.equals("sub")) {
            cartDto.SubItem(item);
            return "redirect:/cart";
        }
        cartDto.addItem(item);
        model.addAttribute("message", "Successfully added !");
        return "redirect:/detail";
    }


}
