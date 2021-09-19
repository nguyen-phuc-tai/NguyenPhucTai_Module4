package com.codegym.model.service.impl;

import com.codegym.model.entity.user.AppRole;
import com.codegym.model.repository.user.IAppRoleRepository;
import com.codegym.model.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements IAppRoleService {
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id).orElse(null);
    }
}
