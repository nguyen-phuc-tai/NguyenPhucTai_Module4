package com.codegym.model.service;

import com.codegym.model.bean.SettingEmail;

import java.util.List;

public interface EmailService {
    List<SettingEmail> findAll();

    SettingEmail findOne(Long id);

    void save(SettingEmail settingEmail);
}
