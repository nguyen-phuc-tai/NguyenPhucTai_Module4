package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.model.entity.Item;
import com.codegym.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ItemsController {

    @ModelAttribute("cart")
    public CartDto getCart() {
        return new CartDto();
    }

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String goToShop(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "item/list";
    }


    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable Integer id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if(item.isPresent()){
            model.addAttribute("item", item);
            return "item/detail";
        }
        model.addAttribute("mgs", "Find not Found");
        return "item/detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, Model model,
                            @SessionAttribute("cart") CartDto cartDto,
                            @RequestParam("action") String action) {
        Optional<Item> item = itemService.findById(id);
        if (!item.isPresent()) {
            model.addAttribute("message", "Find not found");
            return "redirect:/shop";
        }
        if (action.equals("add")) {
            cartDto.addItem(item.get());
            return "redirect:/cart";
        }
        if (action.equals("sub")) {
            cartDto.SubItem(item.get());
            return "redirect:/cart";
        }
        cartDto.addItem(item.get());
        model.addAttribute("message", "Successfully added !");
        return "redirect:/shop";
    }

}
