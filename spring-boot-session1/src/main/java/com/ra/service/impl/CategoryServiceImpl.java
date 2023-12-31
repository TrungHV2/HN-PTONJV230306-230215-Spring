package com.ra.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ra.exception.BaseException;
import com.ra.exception.ErrorCode;
import com.ra.model.dto.CategoryResponse;
import com.ra.model.entity.CategoryEntity;
import com.ra.repository.CategoryRepository;
import com.ra.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryResponse> findAll() {
        try {
            repository.updateCategoryStatus("07265d9f-424f-11ee-9256-0242ac110002", false);
            String key = "%iện%";
            List<CategoryEntity> nativeFalse = repository.findByNameNativeFalse(key);
            List<CategoryEntity> nativeTrue = repository.findByNameNativeTrue(key);
            List<CategoryEntity> data = repository.findByNameLike(key);
            ModelMapper mapper = new ModelMapper();
            List<CategoryResponse> response = data.stream()
                    .map(x -> mapper.map(x, CategoryResponse.class))
                    .collect(Collectors.toList());
            return response;
        } catch (Exception ex) {
            LOGGER.error("CategoryServiceImpl findAll with ex: {}", ex);
            throw new BaseException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CategoryEntity saveOrUpdate(CategoryEntity entity) {
        try {
            LOGGER.info("====Start CategoryServiceImpl saveOrUpdate====");
            entity.setId(UUID.randomUUID().toString());
            LOGGER.info("====Start CategoryServiceImpl saveOrUpdate successfully====");
            return repository.save(entity);
        } catch (Exception ex) {
            LOGGER.error("====Exception CategoryServiceImpl saveOrUpdate with ex: {}====", ex);
            throw ex;
        }
    }
}
