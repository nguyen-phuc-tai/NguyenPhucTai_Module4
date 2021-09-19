package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.entity.service.Services;
import com.codegym.model.service.IServiceService;
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
@RequestMapping(value = "/services")

public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypeList() {
        return serviceService.findAllServiceType();
    }
    @ModelAttribute("rentTypes")
    public List<RentType> rentTypeList() {
        return serviceService.findAllRentType();
    }


    @GetMapping(value = "")
    public String showListServices(Model model, @PageableDefault(size = 2) Pageable pageable,
                                   @RequestParam Optional<String> rentType,
                                   @RequestParam Optional<String> serviceType,
                                   @RequestParam Optional<String> serviceName){

        String keywordRentType = "";
        String keywordServiceType = "";
        String keywordServiceName = "";

        if (rentType.isPresent()) {
            //nếu có giá trị copy vào  biến
            keywordRentType = rentType.get();
        }

        if (serviceType.isPresent()) {
            keywordServiceType = serviceType.get();
        }
        if (serviceName.isPresent()) {
            keywordServiceName = serviceName.get();
        }

        Page<Services> servicesList = serviceService.search(pageable, keywordRentType, keywordServiceType, keywordServiceName);

        model.addAttribute("servicesList", servicesList);
        model.addAttribute("keywordRentType", keywordRentType);
        model.addAttribute("keywordServiceType", keywordServiceType);
        model.addAttribute("keywordServiceName", keywordServiceName);
        return "/service/list";
    }

    @GetMapping(value = "create")
    public String showCreateService(Model model){
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create";
    }

    @PostMapping(value = "save")
    public String saveService(@Valid @ModelAttribute ServiceDto serviceDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            return "service/create";
        }
        Services services = new Services();
        BeanUtils.copyProperties(serviceDto, services);
        this.serviceService.save(services);
        redirectAttributes.addFlashAttribute("success", "Create service successfully");
        return "redirect:/services";
    }

    @GetMapping("/edit{id}")
    public String showEditForm(@RequestParam Long id, Model model){

        Optional <Services> service = serviceService.findById(id);
        if(!service.isPresent()){
            model.addAttribute("msg", "Find not found");
            return "service/list";
        }
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service.get(), serviceDto);
        model.addAttribute("serviceDto",serviceDto);
        return "/service/edit";
    }

    @PostMapping(value = "/edit")
    public String updateService(@Valid @ModelAttribute ServiceDto serviceDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect){

        if (bindingResult.hasErrors()){
            return "service/edit";
        }
        Services service = new Services();
        BeanUtils.copyProperties(serviceDto, service);
        this.serviceService.save(service);

        redirect.addFlashAttribute("success", "Updated service successfully!");
        return "redirect:/services";
    }

    @PostMapping(value = "delete")
    public String deleteService(@RequestParam Optional<List<Long>> listId, RedirectAttributes redirectAttributes) {
        if (listId.isPresent()) {
            for (Long id : listId.get()) {
                Optional<Services> service = serviceService.findById(id);
                if(!service.isPresent()){
                    redirectAttributes.addFlashAttribute("lost", "Find not found!");
                    return "redirect:/services";
                }
                serviceService.remove(id);
            }
        }
        redirectAttributes.addFlashAttribute("success", "Removed successfully!");
        return "redirect:/services";
    }
}