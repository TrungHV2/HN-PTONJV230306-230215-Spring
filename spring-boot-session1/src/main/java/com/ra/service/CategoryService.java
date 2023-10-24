package com.ra.service;

import com.ra.model.dto.CategoryResponse;
import com.ra.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();

    CategoryEntity saveOrUpdate(CategoryEntity entity);
}
