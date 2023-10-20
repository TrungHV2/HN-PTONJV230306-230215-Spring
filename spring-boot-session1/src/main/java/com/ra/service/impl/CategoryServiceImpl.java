package com.ra.service.impl;

import com.ra.model.entity.CategoryEntity;
import com.ra.repository.CategoryRepository;
import com.ra.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryEntity> findAll() {
        String key = "%iện%";
        List<CategoryEntity> nativeFalse = repository.findByNameNativeFalse(key);
        List<CategoryEntity> nativeTrue = repository.findByNameNativeTrue(key);
        return repository.findByNameLike(key);
    }

    @Override
    public CategoryEntity saveOrUpdate(CategoryEntity entity) {
        entity.setId(UUID.randomUUID().toString());
        return repository.save(entity);
    }
}
