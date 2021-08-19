package com.codeup.blogapp.web;


import data.Category;
import data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping(value="/api/categories", headers="Accept=application/json")
public class CategoriesController {

    Collection<Post> userPosts = new ArrayList<>() {{
        add(new Post(1L, "My 1Post", "this is my first post", null));
        add(new Post(2L, "My 2Post", "this is my second post", null));
        add(new Post(3L, "My 3Post", "this is my third post", null));
    }};


    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName) {

        Category Categories = new Category(1L, "Tech");

        Categories.setPosts(userPosts);

        return Categories;

    }
}