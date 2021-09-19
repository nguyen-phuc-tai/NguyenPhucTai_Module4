package com.codegym.model.service;

import com.codegym.model.entity.user.AppUser;

public interface IUserRoleService {
    void save(AppUser appUser, Long id);
}