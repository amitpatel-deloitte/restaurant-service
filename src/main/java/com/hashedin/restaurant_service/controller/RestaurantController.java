package com.hashedin.restaurant_service.controller;

import com.hashedin.restaurant_service.model.MenuIdsDTO;
import com.hashedin.restaurant_service.model.Restaurant;
import com.hashedin.restaurant_service.model.RestaurantInput;
import com.hashedin.restaurant_service.model.RestaurantDTO;
import com.hashedin.restaurant_service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> getAllMenus() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("")
    public Restaurant createRestaurantWithMenu(@RequestBody RestaurantInput restaurant){
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") int id){
        return restaurantService.getRestaurantById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int id, @RequestBody RestaurantDTO restaurantDetails){
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurantDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") int id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-menus-to-restaurant")
    public Restaurant addMenusRestaurant(@RequestParam int restaurantId, @RequestBody MenuIdsDTO menuIdsDTO){
        return restaurantService.addMenusToRestaurant(restaurantId, menuIdsDTO.getMenuIds());
    }

}
