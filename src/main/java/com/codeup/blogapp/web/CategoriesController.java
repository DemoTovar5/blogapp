package com.codeup.blogapp.web;


import data.Category;
import data.Post;
import data.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping(value="/api/categories", headers="Accept=application/json")
public class CategoriesController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;

    }


    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName) {

        return null;

    }
}