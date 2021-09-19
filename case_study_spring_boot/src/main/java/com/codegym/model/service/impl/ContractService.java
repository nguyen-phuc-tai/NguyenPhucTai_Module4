package com.codegym.model.service.impl;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.repository.contract.IAttachServiceRepository;
import com.codegym.model.repository.contract.IContractDetailRepository;
import com.codegym.model.repository.contract.IContractRepository;
import com.codegym.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IAttachServiceRepository attachServiceRepository;
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<Contract> findAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable, String customerName) {
        return contractRepository.findAll(pageable, "%" + customerName + "%");
    }

}