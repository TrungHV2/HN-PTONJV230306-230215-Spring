package com.ra.api;


import com.ra.model.dto.CategoryResponse;
import com.ra.model.entity.CategoryEntity;
import com.ra.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryApi.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> get() {
        return categoryService.findAll();
    }
    @PostMapping
    public CategoryEntity post(@RequestBody CategoryEntity model) {
        //LOGGER.info("=== Start CategoryApi post with request: {}===", model);
        return categoryService.saveOrUpdate(model);
    }
}
