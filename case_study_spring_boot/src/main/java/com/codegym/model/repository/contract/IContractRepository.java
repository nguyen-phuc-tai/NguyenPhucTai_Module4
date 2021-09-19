package com.codegym.model.repository.contract;
import com.codegym.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "select * from contract ct join customer c on ct.customer_id = c.customer_id where " +
            "c.name like :customerName", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable, @Param("customerName") String customerName);
}
