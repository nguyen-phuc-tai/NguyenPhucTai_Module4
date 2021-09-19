package com.codegym.model.service;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IContractService {

    void save(Contract contract);

    List<AttachService> findAllAttachService();

    List<ContractDetail> findAllContractDetail();

    List<Contract> findAllContract();

    Optional<Contract> findById(Long id);

    Page<Contract> findAll(Pageable pageable, @Param("customerName") String customerName);

}
