package com.codegym.model.service;

import com.codegym.model.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();

    Optional<Item> findById(Integer id);

    void save(Item item);

    void remove(Integer id);
}
