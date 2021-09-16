package com.codegym.model.service;

import com.codegym.model.entity.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAll();
    AppRole findById(Long id);
}
