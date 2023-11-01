package com.ra.shop.presentation.api;

import com.ra.shop.persistence.entity.CategoryEntity;
import com.ra.shop.presentation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> get() {
        return categoryService.findAll();
    }
    @GetMapping("/{id}")
    public CategoryEntity get(@PathVariable String id) {
        return categoryService.findId(id);
    }
    @PostMapping
    public CategoryEntity post(@RequestBody CategoryEntity entity) {
        return categoryService.saveOrUpdate(entity);
    }
    @PutMapping("/{id}")
    public CategoryEntity post(@PathVariable String id, @RequestBody CategoryEntity entity) {
        return categoryService.saveOrUpdate(entity);
    }
    @DeleteMapping("/{id}")
    public CategoryEntity delete(@PathVariable String id) {
        return categoryService.remove(id);
    }

}
