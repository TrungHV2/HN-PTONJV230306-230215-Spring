package com.ra.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String roles = "ROLE_ADMIN,ROLE_CUSTOMER";
}
