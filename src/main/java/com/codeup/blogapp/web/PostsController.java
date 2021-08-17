package com.codeup.blogapp.web;

import data.Post;
import data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    @GetMapping
    private List<Post> getPosts() {

        User user = new User(1l,"testy","Testing ","mypassword", User.Role.USER, null);


        return new ArrayList<>() {{
            add(new Post(1L, "My 1Post", "this is my first post",user));
            add(new Post(2L, "My 2Post", "this is my second post",user));
            add(new Post(3L, "My 3Post", "this is my third post",user));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {

        User user = new User(1l,"testy","Testing ","mypassword", User.Role.USER, null);


        if (id == 1) {
            return new Post(1L, "My 1Post", "this is my first post", user);
        } else {
            return null;
        }

    }

    @PostMapping
    private void createPost(@RequestBody Post myPost) {

        System.out.println(myPost.getTitle());
        System.out.println(myPost.getContent());

    }


    @PutMapping("{id}")
    private void updatePost(@RequestBody Post myPost, @PathVariable Long id) {

        System.out.println(myPost);

    }


    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){



    }



}
