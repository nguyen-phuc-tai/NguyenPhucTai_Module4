package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/customers"})
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypeList() {
        return customerService.findAllCustomerType();
    }


    @GetMapping(value = "")
    public String showListCustomer(Model model,
                                   @PageableDefault(size = 2) Pageable pageable,
                                   @RequestParam Optional<String> customerName,
                                   @RequestParam Optional<String> customerTypes) {
        String keywordCusType = "";
        String keywordCustomerName = "";
        if (customerName.isPresent()) {
            //nếu có giá trị copy vào  biến
            keywordCustomerName = customerName.get();
        }
        if (customerTypes.isPresent()) {
            keywordCusType = customerTypes.get();
        }
        Page<Customer> customerList = customerService.search(pageable, keywordCustomerName, keywordCusType);
        model.addAttribute("customers", customerList);
        model.addAttribute("keywordCustomerName", keywordCustomerName);
        model.addAttribute("keywordCusType", keywordCusType);
        return "/customer/list";

    }

    @GetMapping(value = "/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        Optional<Customer> code = customerService.findAllByCustomerCode(customerDto.getCustomerCode());
        if(code.isPresent()){
            model.addAttribute("customerCode","Mã khách hàng đã tồn tại");
            return "/customer/create";
        }

        Optional<Customer> phone = customerService.findAllByPhone(customerDto.getPhone());
        if(phone.isPresent()){
            model.addAttribute("customerPhone","Số điện thoại đã được đăng kí");
            return "/customer/create";
        }
        Optional<Customer> email = customerService.findAllByEmail(customerDto.getEmail());
        if(email.isPresent()){
            model.addAttribute("customerEmail","Email đã được đăng kí");
            return "/customer/create";
        }

        if (bindingResult.hasErrors()) {
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Create customer successfully");
        return "redirect:/customers";
    }

    @GetMapping("/edit{id}")
    public String showEditForm(@RequestParam Long id, Model model) {

        Optional <Customer> customer = customerService.findById(id);
        if(!customer.isPresent()){
            model.addAttribute("lost", "Find not Found");
            return "customer/list";
        }

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        model.addAttribute("customerDto",customerDto);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirect.addFlashAttribute("success", "Updated customer  successfully!");
        return "redirect:/customers";
    }

    @PostMapping(value = "delete")
    public String deleteCustomer(@RequestParam Optional<List<Long>> listId, RedirectAttributes redirectAttributes) {
        if (listId.isPresent()) {
            for (Long id : listId.get()) {
                Optional<Customer> customer = customerService.findById(id);

                if(!customer.isPresent()){
                    redirectAttributes.addFlashAttribute("lost", "Find not found!");
                    return "redirect:/customers";
                }
                customerService.remove(id);
            }
        }
        redirectAttributes.addFlashAttribute("success", "Removed  successfully!");
        return "redirect:/customers";
    }
}