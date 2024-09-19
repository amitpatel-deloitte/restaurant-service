package com.hashedin.restaurant_service.eexceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomErrorResponse {
    private String timestamp;
    private int status;
    private String message;
    private String path;
}
