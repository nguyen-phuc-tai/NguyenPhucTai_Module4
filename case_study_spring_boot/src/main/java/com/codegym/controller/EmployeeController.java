package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.service.IEmployeeService;
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
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @ModelAttribute(value = "divisions")
    public List<Division> divisionList(){
        return employeeService.findAllDivision();
    }
    @ModelAttribute(value = "educationDegrees")
    public List<EducationDegree> educationDegreeList(){
        return employeeService.findAllEducationDegree();
    }
    @ModelAttribute(value = "positions")
    public List<Position> positionList(){
        return employeeService.findAllPosition();
    }

    @GetMapping(value = "/create")
    public String createEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping(value = "/save")
    public String saveEmployee(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        Optional<Employee> phone = employeeService.findAllByPhone(employeeDto.getEmployeePhone());
        if(phone.isPresent()){
            model.addAttribute("employeePhone","Số điện thoại đã được đăng kí");
            return "/employee/create";
        }
        Optional<Employee> email = employeeService.findAllByEmail(employeeDto.getEmployeeEmail());
        if(email.isPresent()){
            model.addAttribute("employeeEmail","Email đã được đăng kí");
            return "/employee/create";
        }

        if (bindingResult.hasErrors()) {
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Create employee successfully!");
        return "redirect:/employees";
    }

    @GetMapping(value = "")
    public String showListEmployee(Model model,
                                   @PageableDefault(size = 2) Pageable pageable,
                                   @RequestParam Optional<String> employeeDivition,
                                   @RequestParam Optional<String> employeePosition,
                                   @RequestParam Optional<String> employeeName) {
        String keywordEmployDi = "";
        String keywordEmployPo = "";
        String keywordEmployeeName = "";

        if (employeeDivition.isPresent()) {
            //nếu có giá trị copy vào  biến
            keywordEmployDi = employeeDivition.get();
        }

        if (employeePosition.isPresent()) {
            keywordEmployPo = employeePosition.get();
        }
        if (employeeName.isPresent()) {
            keywordEmployeeName = employeeName.get();
        }

        Page<Employee> employees = employeeService.search(pageable, keywordEmployDi, keywordEmployPo , keywordEmployeeName);

        model.addAttribute("employees", employees);
        model.addAttribute("keywordEmployDi", keywordEmployDi);
        model.addAttribute("keywordEmployPo", keywordEmployPo);
        model.addAttribute("keywordEmployeeName", keywordEmployeeName);
        return "/employee/list";

    }

    @PostMapping(value = "delete")
    public String deleteEmployee(@RequestParam Optional<List<Long>> listId, RedirectAttributes redirectAttributes) {
        if (listId.isPresent()) {
            for (Long id : listId.get()) {
                Optional<Employee> employee = employeeService.findById(id);
                if(!employee.isPresent()){
                    redirectAttributes.addFlashAttribute("lost", "Find not found!");
                    return "redirect:/employees";
                }
                employeeService.remove(id);
            }
        }
        redirectAttributes.addFlashAttribute("success", "Removed successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/edit{id}")
    public String showEditForm(@RequestParam Long id, Model model) {
       Optional <Employee> employee = employeeService.findById(id);
       if(!employee.isPresent()){
           model.addAttribute("lost", "Find not Found");
           return "employee/list";
       }
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(),employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String updateEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);

        redirect.addFlashAttribute("success", "Updated employee information successfully!");
        return "redirect:/employees";
    }

}