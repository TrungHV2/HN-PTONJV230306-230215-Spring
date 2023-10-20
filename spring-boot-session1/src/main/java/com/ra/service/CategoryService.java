package com.ra.service;

import com.ra.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findAll();

    CategoryEntity saveOrUpdate(CategoryEntity entity);
}
