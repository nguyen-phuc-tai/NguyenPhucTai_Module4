package com.codegym.model.service.impl;

import com.codegym.model.entity.user.AppUser;
import com.codegym.model.entity.user.UserRole;
import com.codegym.model.repository.user.IAppRoleRepository;
import com.codegym.model.repository.user.IRoleUserRepository;
import com.codegym.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IRoleUserRepository userRoleRepository;
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public void save(AppUser appUser, Long id) {
            this.userRoleRepository.save(new UserRole(appUser,this.appRoleRepository.findById(id).orElse(null)));
    }
}
