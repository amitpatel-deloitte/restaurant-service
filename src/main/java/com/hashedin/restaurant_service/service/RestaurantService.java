package com.hashedin.restaurant_service.service;

import com.hashedin.restaurant_service.exceptionHandler.NotFoundException;
import com.hashedin.restaurant_service.model.Menu;
import com.hashedin.restaurant_service.model.Restaurant;
import com.hashedin.restaurant_service.model.RestaurantInput;
import com.hashedin.restaurant_service.model.RestaurantDTO;
import com.hashedin.restaurant_service.repository.MenuRepository;
import com.hashedin.restaurant_service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    public Restaurant createRestaurant(RestaurantInput restaurant) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setRestaurant_name(restaurant.getName());
        newRestaurant.setCuisine_type(restaurant.getCuisine_type());
        newRestaurant.setContact_info(restaurant.getContact_info());
        newRestaurant.setLocation(restaurant.getLocation());

        return restaurantRepository.save(newRestaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( " Restaurant with " + id + " not found"));
    }

    public Restaurant addMenusToRestaurant(int restaurantId, List<Integer> menuIds){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException( "Restaurant with " + restaurantId + " not found"));

        List<Menu> menus = menuRepository.findAllById(menuIds);
        restaurant.setMenus(menus);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(int id, RestaurantDTO restaurantDetails) {
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( " Restaurant with " + id + " not found"));

        if(restaurantDetails.getName() != null){
            existingRestaurant.setRestaurant_name(restaurantDetails.getName());
        }
        if(restaurantDetails.getLocation() != null){
            existingRestaurant.setLocation(restaurantDetails.getLocation());
        }
        if(restaurantDetails.getCuisine_type() != null){
            existingRestaurant.setCuisine_type(restaurantDetails.getCuisine_type());
        }
        if(restaurantDetails.getContact_info() != null){
            existingRestaurant.setContact_info(restaurantDetails.getContact_info());
        }
        if(restaurantDetails.getMenuIds() != null && !restaurantDetails.getMenuIds().isEmpty()){
            List<Menu> menus = menuRepository.findAllById(restaurantDetails.getMenuIds());
            existingRestaurant.setMenus(menus);
        }
        return restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurant(int id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( "Restaurant with " + id + " not found"));
        restaurant.getMenus().clear();
        restaurantRepository.delete(restaurant);
    }
}
