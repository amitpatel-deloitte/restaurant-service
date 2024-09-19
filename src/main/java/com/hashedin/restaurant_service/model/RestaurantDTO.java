package com.hashedin.restaurant_service.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private String name;
    private String location;
    private String cuisine_type;
    private String contact_info;
    private List<Integer> menuIds;
}
