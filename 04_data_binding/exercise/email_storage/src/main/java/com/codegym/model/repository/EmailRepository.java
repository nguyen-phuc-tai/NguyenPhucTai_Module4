package com.codegym.model.repository;

import com.codegym.model.bean.SettingEmail;

import java.util.List;

public interface EmailRepository {
    List<SettingEmail> findAll();

    SettingEmail findOne(Long id);

    void save(SettingEmail settingEmail);
}
