package com.hashedin.restaurant_service.controller;

import com.hashedin.restaurant_service.model.Menu;
import com.hashedin.restaurant_service.model.MenuDTO;
import com.hashedin.restaurant_service.service.MenuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/menu")
@RestController
@Tag(name = " Menu Controller ")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") int id) {
        return menuService.getMenuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Menu createMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.createMenuWithItems(menuDTO.getName(), menuDTO.getItemIds());
    }

    @PutMapping("/update/menu/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") int id, @RequestBody MenuDTO menuDetails) {
        return ResponseEntity.ok(menuService.updateMenu(id, menuDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("id") int id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }

}
