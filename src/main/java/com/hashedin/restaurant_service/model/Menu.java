package com.hashedin.restaurant_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Menu")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int menu_id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "menu_items",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;
}
