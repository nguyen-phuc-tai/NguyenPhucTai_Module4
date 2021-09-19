package com.codegym.model.service.impl;

import com.codegym.model.entity.user.AppUser;
import com.codegym.model.repository.user.IAppUserRepository;
import com.codegym.model.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Override
    public AppUser findByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
