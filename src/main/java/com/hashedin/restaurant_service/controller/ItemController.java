package com.hashedin.restaurant_service.controller;

import com.hashedin.restaurant_service.model.Item;
import com.hashedin.restaurant_service.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item")
@RestController
@Tag(name = " Items Controls/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    @Operation(summary = "Get all items ")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get items by Item id ")
    public ResponseEntity<Item> getItemById(@PathVariable("id") int id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = " Create Items ")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = " Update items by Id ")
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id, @RequestBody Item itemDetails) {
        return ResponseEntity.ok(itemService.updateItem(id, itemDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "To delete items by Id")
    public String deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return "Item with id: " + id + " deleted successfully ";
    }
}
