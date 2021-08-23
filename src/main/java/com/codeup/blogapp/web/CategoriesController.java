package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/categories", headers="Accept=application/json")
public class CategoriesController {

    private final CategoryRepository CategoryRepository;

    public CategoriesController(CategoryRepository categoryRepository){
        this.CategoryRepository = categoryRepository;

    }


//    @GetMapping
//    private Category getPostsByCategory(@RequestParam String categoryName) {
//
//        return null;
//
//    }

    @GetMapping
    private List<Category> getCategories() {

        return CategoryRepository.findAll();

    }
}