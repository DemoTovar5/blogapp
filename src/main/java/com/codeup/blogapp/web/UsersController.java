package com.codeup.blogapp.web;


import com.codeup.blogapp.data.User;
import com.codeup.blogapp.data.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserRepository userRepository;
    privae


    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;

    }


    @GetMapping
    private List<User> getUsers() {
        return userRepository.findAll();

    }

        @PostMapping
        private void createUser(@RequestBody User myUser) {

        userRepository.save(myUser);

            System.out.println(myUser.getId());
            System.out.println(myUser.getUsername());
            System.out.println(myUser.getEmail());
            System.out.println(myUser.getPassword());
            System.out.println(myUser.getRole());

        }

    @PutMapping("/{id}")
    private void updateUser(@RequestBody User user, @PathVariable Long id) {

        userRepository.save(user);

//        System.out.println(user.getId());
//        System.out.println(myUser.getUsername());
//        System.out.println(myUser.getEmail());
//        System.out.println(myUser.getPassword());
//        System.out.println(myUser.getRole());

    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){

        userRepository.deleteById(id);

    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {

        return userRepository.findById(id).get();
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

        userRepository.getById(id).setPassword(newPassword);

    System.out.println("Old Password:" + oldPassword);
    System.out.println("New Password:" + newPassword);

}




}