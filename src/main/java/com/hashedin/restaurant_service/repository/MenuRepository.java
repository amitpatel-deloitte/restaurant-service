package com.hashedin.restaurant_service.repository;

import com.hashedin.restaurant_service.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
