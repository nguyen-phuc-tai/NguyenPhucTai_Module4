package com.codegym.model.service;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    void save(Services service);

    void remove(Long id);

    Optional<Services> findById(Long id);

    List<ServiceType> findAllServiceType();

    List<RentType> findAllRentType();

    Page<Services> findAll(Pageable pageable);
    List<Services> findAll();

    Page<Services> search(Pageable pageable,
                          @Param("rentType") String rentType,
                          @Param("serviceType") String serviceType,
                          @Param("serviceName") String serviceName);

}
