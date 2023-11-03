package com.ra.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class CustomerRequest {
    private String id;
    private String name;
    private int age;
    private Date birthday;
    private String avatar;
}
