package com.ra.service.impl;

import com.ra.model.entity.CategoryEntity;
import com.ra.model.entity.ProductEntity;
import com.ra.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void insert(ProductEntity entity) {
        CategoryEntity c = new CategoryEntity();
        c.setId("0b4e4133-424f-11ee-9256-0242ac110002");
        entity.setCategory(c);
    }
}
