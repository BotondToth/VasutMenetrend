package com.database.szte.controller;

import com.database.szte.data.ApplicationUser;
import com.database.szte.dto.UserDTO;
import com.database.szte.service.IUserService;
import com.database.szte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/user/id")
    public ApplicationUser getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/email")
    public ApplicationUser getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    */
    @PostMapping("/register")
    public ApplicationUser signUpNewUser(@RequestBody UserDTO userDTO) {
        return userService.saveNewUser(new ApplicationUser(userDTO));
    }

}
