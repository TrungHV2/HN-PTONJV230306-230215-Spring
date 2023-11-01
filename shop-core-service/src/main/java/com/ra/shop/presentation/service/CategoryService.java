package com.ra.shop.presentation.service;

import com.ra.shop.persistence.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findAll();
    List<CategoryEntity> findByName(String name);
    CategoryEntity findId(String id);
    CategoryEntity saveOrUpdate(CategoryEntity entity);
    CategoryEntity remove(String id);
}
