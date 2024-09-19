package com.hashedin.restaurant_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Restaurant")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int restaurant_id;
    @Column(nullable = false)
    private String restaurant_name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = true)
    private String cuisine_type;
    @Column(nullable = false)
    private String contact_info;

    @ManyToMany
    @JoinTable(
            name = "restaurant_menus",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menus;
}

