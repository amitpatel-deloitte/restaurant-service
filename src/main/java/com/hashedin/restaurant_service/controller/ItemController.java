package com.hashedin.restaurant_service.controller;

import com.hashedin.restaurant_service.model.Item;
import com.hashedin.restaurant_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") int id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id, @RequestBody Item itemDetails) {
        System.out.println(" getststt");
        return ResponseEntity.ok(itemService.updateItem(id, itemDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
