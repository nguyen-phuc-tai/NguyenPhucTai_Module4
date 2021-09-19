package com.codegym.model.service.impl;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.entity.service.Services;
import com.codegym.model.repository.service.IRentTypeRepository;
import com.codegym.model.repository.service.IServiceRepository;
import com.codegym.model.repository.service.IServiceTypeRepository;
import com.codegym.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public void save(Services services) {
        serviceRepository.save(services);

    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Optional<Services> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }


    @Override
    public Page<Services> search(Pageable pageable, String rentType, String serviceType, String serviceName) {
        return serviceRepository.search(pageable, "%" + rentType + "%", "%" + serviceType + "%",
                "%" + serviceName + "%");
    }
}