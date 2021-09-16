package com.codegym.model.repository;

import com.codegym.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
