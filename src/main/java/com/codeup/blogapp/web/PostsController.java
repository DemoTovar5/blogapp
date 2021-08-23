package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;

    }

    @GetMapping
    private List<Post> getPosts() {

    return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {

        return postsRepository.findById(id).get();

    }

    @PostMapping
    private void createPost(@RequestBody Post myPost) {

        System.out.println(myPost.getTitle());
        System.out.println(myPost.getContent());

        postsRepository.save(myPost);

    }


    @PutMapping("{id}")
    private void updatePost(@RequestBody Post myPost, @PathVariable Long id) {

        System.out.println(myPost);
//        Post existingPost = postsRepository.getById(id);
        postsRepository.save(myPost);

    }


    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
    postsRepository.deleteById(id);

    }



}
