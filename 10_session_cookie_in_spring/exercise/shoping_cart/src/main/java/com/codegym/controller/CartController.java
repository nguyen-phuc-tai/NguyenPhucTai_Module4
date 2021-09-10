package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.model.entity.Item;
import com.codegym.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private ItemService itemService;

    @ModelAttribute("cart")
    public CartDto getCart() {
        return new CartDto();
    }

    @GetMapping("/cart")
    public String getCartPage(@SessionAttribute(value = "cart", required = false) CartDto cartDto, Model model) {
        model.addAttribute("cart", cartDto);
        return "cart/list";
    }

    @GetMapping("/cart/delete/{id}")
    public String removeItem(@SessionAttribute("cart") CartDto cartDto, @PathVariable("id") Integer id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if(!item.isPresent()){
            model.addAttribute("mgs", "Find not Found");
            return "redirect:/cart";
        }
        cartDto.removeItem(item.get());
        return "redirect:/cart";
    }
}
