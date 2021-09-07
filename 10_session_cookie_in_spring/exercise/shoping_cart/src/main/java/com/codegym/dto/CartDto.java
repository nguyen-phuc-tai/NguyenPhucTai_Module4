package com.codegym.dto;

import com.codegym.model.entity.Item;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<Item,Integer> items = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<Item,Integer> items) {
        this.items = items;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
    }

    public Map<Item,Integer> getItems() {
        return items;
    }

    private boolean checkItemInCart(Item item){
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            if(entry.getKey().getId().equals(item.getId())){
                return true;
            }
        }
        return false;
    }

    public void addItem(Item item){
        if (!checkItemInCart(item)){
            items.put(item,1);
        } else {
            Map.Entry<Item, Integer> itemEntry = selectItemInCart(item);
            Integer newQuantity = itemEntry.getValue() + 1;
            items.replace(itemEntry.getKey(),newQuantity);
        }
    }

    private Map.Entry<Item, Integer> selectItemInCart(Item item){
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            if(entry.getKey().getId().equals(item.getId())){
                return entry;
            }
        }
        return null;
    }



    public  void SubItem(Item item){
        if (checkItemInCart(item)){
            Map.Entry<Item,Integer> integerEntry=selectItemInCart(item);
            Integer newQuantity=integerEntry.getValue()-1;
            if (newQuantity==0){
                this.removeItem(item);
            }
            else {
                items.replace(integerEntry.getKey(),newQuantity);
            }

        }
    }
    public void removeItem(Item item){
        Map.Entry<Item,Integer> integerEntry=selectItemInCart(item);
        items.remove(integerEntry.getKey());
    }

    public  Double toTalItem(){
        Double total=0.0;
        for (Map.Entry<Item,Integer> item :items.entrySet()
        ) {
            total+=item.getKey().getPrice()*item.getValue();
        }

        return total;
    }
}
