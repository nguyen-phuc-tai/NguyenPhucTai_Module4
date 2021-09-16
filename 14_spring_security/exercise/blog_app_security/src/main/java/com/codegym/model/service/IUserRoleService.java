package com.codegym.model.service;

import com.codegym.model.entity.AppUser;

public interface IUserRoleService {
    void save(AppUser appUser, Long id);
}