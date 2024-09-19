package com.hashedin.restaurant_service.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantInput {
    private String name;
    private String location;
    private String cuisine_type;
    private String contact_info;
}
