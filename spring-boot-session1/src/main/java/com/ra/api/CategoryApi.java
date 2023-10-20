package com.ra.api;


import com.ra.model.entity.CategoryEntity;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> get() {
        return categoryService.findAll();
    }
    @PostMapping
    public CategoryEntity post(@RequestBody CategoryEntity model) {
        return categoryService.saveOrUpdate(model);
    }
}
