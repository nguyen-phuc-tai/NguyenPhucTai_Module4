package com.codegym.model.repository.service;

import com.codegym.model.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services, Long> {

    Page<Services> findAll(Pageable pageable);

    @Query(value = "select * from services s join rent_type r on s.rent_type_id = r.rent_type_id join" +
            " service_type st on s.service_type_id = st.service_type_id where" +
            " r.rent_type_name like :rentType and st.service_type_name like :serviceType and" +
            " s.service_name like :serviceName", nativeQuery = true)
    Page<Services> search(Pageable pageable,
                          @Param("rentType") String rentType,
                          @Param("serviceType") String serviceType,
                          @Param("serviceName") String serviceName);
}