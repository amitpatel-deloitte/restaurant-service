package com.hashedin.restaurant_service.repository;

import com.hashedin.restaurant_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
