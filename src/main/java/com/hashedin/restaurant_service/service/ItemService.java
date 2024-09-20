package com.hashedin.restaurant_service.service;

import com.hashedin.restaurant_service.exceptionHandler.NotFoundException;
import com.hashedin.restaurant_service.model.Item;
import com.hashedin.restaurant_service.model.Menu;
import com.hashedin.restaurant_service.repository.ItemRepository;
import com.hashedin.restaurant_service.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(int id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( "Item with " + id + " not found"));
        return itemRepository.findById(id);
    }

    public Item createItem( Item item) {
        return itemRepository.save(item);
    }
    public Item updateItem(int id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( "Item with " + id + " not found"));

        if(itemDetails.getItem_name() != null){
            item.setItem_name(itemDetails.getItem_name());
        }
        if(item.getDescription() != null){
            item.setDescription(itemDetails.getDescription());
        }
        item.setPrice(itemDetails.getPrice());
        item.setAvailable(itemDetails.isAvailable());
        return itemRepository.save(item);
    }

    public void deleteItem(int id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( "Item with " + id + " not found"));
        itemRepository.delete(item);
    }
}
