package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee e join division di on e.division_id = di.division_id join" +
            " position po on e.position_id= po.position_id where di.division_name like :employeeDi and " +
            " po.position_name like :employeePo and e.employee_name like :emlpoyeeName ",nativeQuery = true)
    Page<Employee> search(Pageable pageable,
                          @Param("employeeDi") String employeeDi,
                          @Param("employeePo") String employeePo,
                          @Param("emlpoyeeName") String emlpoyeeName);

    Optional<Employee> findAllByEmployeeEmail(String email);
    Optional<Employee> findAllByEmployeePhone(String phone);
}
