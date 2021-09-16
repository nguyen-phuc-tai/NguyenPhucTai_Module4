package com.codegym.model.service.impl;

import com.codegym.model.entity.AppUser;
import com.codegym.model.entity.UserRole;
import com.codegym.model.repository.IAppRoleRepository;
import com.codegym.model.repository.IRoleUserRepository;
import com.codegym.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    IRoleUserRepository userRoleRepository;
    @Autowired
    IAppRoleRepository appRoleRepository;
    @Override
    public void save(AppUser appUser, Long id) {
        this.userRoleRepository.save(new UserRole(appUser,this.appRoleRepository.findById(id).orElse(null)));
    }
}
