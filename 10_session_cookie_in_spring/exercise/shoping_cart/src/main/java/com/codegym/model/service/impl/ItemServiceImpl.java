package com.codegym.model.service.impl;

import com.codegym.model.entity.Item;
import com.codegym.model.repository.ItemRepository;
import com.codegym.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void remove(Integer id) {
        itemRepository.deleteById(id);
    }
}
