package com.codegym.model.service;

import com.codegym.model.entity.User;
import com.codegym.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findAllByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }
}
