package com.ra.catalog.api;

import com.ra.catalog.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesApi {
    @GetMapping
    public List<Category> get() {
        return Arrays.asList(
                new Category("C01", "Category 01", true),
                new Category("C02", "Category 02", true),
                new Category("C03", "Category 03", false),
                new Category("C04", "Category 04", true),
                new Category("C05", "Category 05", false)
        );
    }
}
