package com.hashedin.restaurant_service.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private String name;
    private List<Integer> itemIds;
}
