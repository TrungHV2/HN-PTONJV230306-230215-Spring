package com.ra.shop.presentation.service.impl;

import com.ra.shop.exception.ErrorCode;
import com.ra.shop.exception.RaException;
import com.ra.shop.persistence.entity.CategoryEntity;
import com.ra.shop.persistence.repository.CategoryRepository;
import com.ra.shop.presentation.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CategoryEntity> findByName(String name) {
        return repository.findByNameLike("%" + name + "%");
    }

    @Override
    public CategoryEntity findId(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity saveOrUpdate(CategoryEntity entity) {
        try {
            LOGGER.info("[START] CategoryServiceImpl saveOrUpdate");
            repository.save(entity);
            LOGGER.info("[END] CategoryServiceImpl saveOrUpdate successfully");
            return entity;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] CategoryServiceImpl saveOrUpdate with ex: {}", ex);
            throw new RaException(ErrorCode.SQL_ERROR);
        }
    }

    @Override
    public CategoryEntity remove(String id) {
        try {
            CategoryEntity entity = findId(id);
            repository.delete(entity);
            return entity;
        } catch (Exception ex) {
            throw new RaException(ErrorCode.SQL_ERROR);
        }
    }
}
