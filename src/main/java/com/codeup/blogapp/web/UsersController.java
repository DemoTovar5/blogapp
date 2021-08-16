package com.codeup.blogapp.web;


import data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {


    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<User>() {{
            add(new User(1L, "User1", "Email1", "password1", User.Role.USER));
            add(new User(2L, "User2", "Email2", "password2", User.Role.ADMIN));
            add(new User(3L, "User3", "Email3", "password3", User.Role.USER));
            add(new User(4L, "User4", "Email4", "password4", User.Role.USER));
        }};

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


}