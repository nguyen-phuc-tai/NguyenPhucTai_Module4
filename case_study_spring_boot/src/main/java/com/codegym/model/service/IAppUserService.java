package com.codegym.model.service;

import com.codegym.model.entity.user.AppUser;

import java.util.List;

public interface IAppUserService {
    AppUser findByUserName(String userName);
    void save(AppUser appUser);
    List<AppUser> findAll();
}
