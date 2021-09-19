package com.codegym.model.repository.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer c join " +
            "customer_type cus_type on c.customer_type_id = cus_type.customer_type_id" +
            " where c.`name` like :customerName and cus_type.customer_type_name like :customerType", nativeQuery = true)
    Page<Customer> search(Pageable pageable,  @Param("customerName") String name, @Param("customerType") String customerType);

    Optional<Customer> findAllByEmail(String email);
}