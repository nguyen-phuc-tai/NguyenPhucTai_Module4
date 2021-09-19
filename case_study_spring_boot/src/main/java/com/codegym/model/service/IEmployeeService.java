package com.codegym.model.service;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(Long id);

    Page<Employee> search(Pageable pageable,
                          @Param("employeeDi") String employeeDi,
                          @Param("employeePo") String employeePo,
                          @Param("emlpoyeeName") String emlpoyeeName);

    void save(Employee employee);

    void remove(Long id);



    List<Division> findAllDivision();
    List<EducationDegree> findAllEducationDegree();
    List<Position> findAllPosition();

}