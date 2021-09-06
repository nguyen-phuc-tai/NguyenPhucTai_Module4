package com.codegym.model.service;

import com.codegym.model.entity.User;

import java.util.Optional;

public interface IUserService {
    void save(User user);

    Optional<User> findAllByEmail(String email);
}
