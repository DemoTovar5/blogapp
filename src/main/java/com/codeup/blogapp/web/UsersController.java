package com.codeup.blogapp.web;


import data.Post;
import data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    User user = new User(1L,"testy","Testing","mypassword", User.Role.USER, null);

    List<Post> posts = new ArrayList<>(){{

        add(new Post(1L, "My 1Post", "this is my first post",user));
        add(new Post(2L, "My 2Post", "this is my second post",user));
        add(new Post(3L, "My 3Post", "this is my third post",user));

    }};


    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<User>() {{
            add(new User(1L, "User1", "Email1", "password1", User.Role.USER,null));
            add(new User(2L, "User2", "Email2", "password2", User.Role.ADMIN,null));
            add(new User(3L, "User3", "Email3", "password3", User.Role.USER,null));
            add(new User(4L, "User4", "Email4", "password4", User.Role.USER,null));
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

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        User user = getUsers().stream()
                .filter(t -> id.equals(t.getId())).findFirst().orElse(null);
        return user;
    }

    @GetMapping("/findByUsername")
private User findByUsername(@RequestParam String username){
    User user = getUsers().stream()
            .filter(t ->
                    username.equals(t.getUsername())).findFirst().orElse(null);
    return user;

}

@GetMapping("/findByEmail")
private User findByEmail(@RequestParam String email){
    User user = getUsers().stream()
            .filter(t -> email.equals(t.getEmail())).findFirst().orElse(null);
    return user;

}

@GetMapping("{id}/updatePassword")
private void updatePassword( @PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){

    System.out.println(oldPassword);
    System.out.println(newPassword);

}




}