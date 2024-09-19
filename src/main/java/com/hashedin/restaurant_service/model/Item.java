package com.hashedin.restaurant_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Item")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int item_id;
    @Column(nullable = false)
    private String item_name;
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private boolean isAvailable;
}
