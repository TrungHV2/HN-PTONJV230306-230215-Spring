package com.ra.model;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private String tokenType = "Bearer";
}
