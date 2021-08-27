package com.codegym.model.service;

import com.codegym.model.bean.SettingEmail;
import com.codegym.model.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<SettingEmail> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public SettingEmail findOne(Long id) {
        return emailRepository.findOne(id);
    }

    @Override
    public void save(SettingEmail settingEmail) {
        emailRepository.save(settingEmail);
    }
}
