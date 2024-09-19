package com.hashedin.restaurant_service.repository;

import com.hashedin.restaurant_service.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
