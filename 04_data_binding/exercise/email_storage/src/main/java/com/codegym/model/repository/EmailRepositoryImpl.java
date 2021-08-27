package com.codegym.model.repository;

import com.codegym.model.bean.SettingEmail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepositoryImpl implements EmailRepository{

    private static List<SettingEmail> emailList = new ArrayList<>();

    @Override
    public List<SettingEmail> findAll() {
        return new ArrayList<>(emailList);
    }

    @Override
    public SettingEmail findOne(Long id) {
        return emailList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(SettingEmail settingEmail) {
        emailList.add(settingEmail);
    }
}
