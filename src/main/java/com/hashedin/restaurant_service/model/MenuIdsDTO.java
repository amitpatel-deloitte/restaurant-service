package com.hashedin.restaurant_service.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuIdsDTO {
    private List<Integer> menuIds;
}
