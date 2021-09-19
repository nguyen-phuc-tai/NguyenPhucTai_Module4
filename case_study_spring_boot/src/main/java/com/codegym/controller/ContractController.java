package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Services;
import com.codegym.model.service.IContractService;
import com.codegym.model.service.ICustomerService;
import com.codegym.model.service.IEmployeeService;
import com.codegym.model.service.IServiceService;
import com.codegym.model.service.impl.ContractDetailService;
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
@RequestMapping(value = "contracts")
public class ContractController {

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;

    @ModelAttribute(value = "customers")
    public Page<Customer> customerPage(Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @ModelAttribute(value = "employees")
    public Page<Employee> employeePage(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @ModelAttribute(value = "services")
    Page<Services> servicesPage(Pageable pageable) {
        return serviceService.findAll(pageable);
    }

    @ModelAttribute(value = "contractDetail")
    Page<ContractDetail> contractDetailPage(Pageable pageable){
        return contractDetailService.findAll(pageable);
    }

    @GetMapping(value = "")
    public String showListContract(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> customerName){
        String keywordCustomerName = "";
        if (customerName.isPresent()) {
            keywordCustomerName = customerName.get();
        }
        Page<Contract> contractList = contractService.findAll(pageable, keywordCustomerName);
        model.addAttribute("contractList", contractList);
        model.addAttribute("keywordCustomerName", keywordCustomerName);
        return "contract/list";
    }

    @GetMapping(value = "create")
    public String showCreateContract(Model model) {

        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping(value = "save")
    public String saveService(@Valid @ModelAttribute ContractDto contractDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        List<Services> serviceList = serviceService.findAll();

        for (Services service : serviceList) {
            if (contractDto.getServices().getServiceName().equals(service.getServiceName())) {
                contractDto.setContractTotalMoney(service.getServiceCost());
            }
        }

        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("success","Create contract successfully!");
        return "redirect:/contracts";

    }

    @GetMapping("/edit{id}")
    public String showEditContract(@RequestParam Long id, Model model) {
        Optional<Contract> contract = contractService.findById(id);
        if(!contract.isPresent()){
            model.addAttribute("lost", "Find not found");
            return "/contract/list";
        }
        ContractDto contractDto = new ContractDto() ;
        BeanUtils.copyProperties(contract.get(), contractDto);
        System.err.println(contractDto.getContractId());
        model.addAttribute("contractDto", contractDto);
        return "/contract/edit";
    }

    @PostMapping(value = "/edit")
    public String editService(@Valid @ModelAttribute ContractDto contractDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        List<Services> serviceList = serviceService.findAll();

        for (Services service : serviceList) {
            if (contractDto.getServices().getServiceName().equals(service.getServiceName())) {
                contractDto.setContractTotalMoney(service.getServiceCost());
            }
        }

        if (bindingResult.hasErrors()) {
            return "contract/edit";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("success","Edit contract successfully");
        return "redirect:/contracts";

    }

}