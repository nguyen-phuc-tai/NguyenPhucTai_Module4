package com.codegym.model.service.impl;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.repository.employee.IDivisionRepository;
import com.codegym.model.repository.employee.IEducationDegreeRepository;
import com.codegym.model.repository.employee.IEmployeeRepository;
import com.codegym.model.repository.employee.IPositionRepository;
import com.codegym.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IDivisionRepository divisionRepository;
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable) ;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> search(Pageable pageable, String employeeDi, String employeePo, String emlpoyeeName) {
        return employeeRepository.search(pageable, "%" + employeeDi + "%","%" + employeePo + "%", "%" + emlpoyeeName + "%");
    }


    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {

        employeeRepository.deleteById(id);
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}