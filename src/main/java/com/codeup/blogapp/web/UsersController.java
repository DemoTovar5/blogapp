package com.codeup.blogapp.web;


import data.Post;
import data.PostsRepository;
import data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;

    }


    @GetMapping
    private List<User> getUsers() {
        return null;

    }

        @PostMapping
        private void createUser(@RequestBody User myUser) {

            System.out.println(myUser.getId());
            System.out.println(myUser.getUsername());
            System.out.println(myUser.getEmail());
            System.out.println(myUser.getPassword());
            System.out.println(myUser.getRole());

        }

    @PutMapping("{id}")
    private void updateUser(@RequestBody User myUser, @PathVariable Long id) {

        System.out.println(myUser.getId());
        System.out.println(myUser.getUsername());
        System.out.println(myUser.getEmail());
        System.out.println(myUser.getPassword());
        System.out.println(myUser.getRole());

    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){


    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/findByUsername")
private User findByUsername(@RequestParam String username){

    return null;

}

@GetMapping("/findByEmail")
private User findByEmail(@RequestParam String email){

    return null;

}

@PutMapping("{id}/updatePassword")
private void updatePassword( @PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){

    System.out.println("Old Password:" + oldPassword);
    System.out.println("New Password:" + newPassword);

}




}