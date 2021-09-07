package com.codegym.controller;

import com.codegym.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public CartDto getCart() {
        return new CartDto();
    }

    @GetMapping("/cart")
    public String getCartPage(@SessionAttribute("cart") CartDto cartDto, Model model) {
        model.addAttribute("cart", cartDto);
        return "cart/list";
    }

    @GetMapping("/cart/delete/{id}")
    public String removeItem(@SessionAttribute("cart") CartDto cartDto, @PathVariable("id") Integer id) {
        cartDto.removeItem(itemService.findById(id));
        return "redirect:/cart";
    }
}
