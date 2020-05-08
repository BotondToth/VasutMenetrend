package com.database.szte.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.database.szte.data.ApplicationUser;
import com.database.szte.dto.UserDTO;
import com.database.szte.security.WebSecurity;
import com.database.szte.service.IUserService;
import com.database.szte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

    @GetMapping("/user/get_info")
    public ApplicationUser getUserInfo(@RequestParam("token") String token) {
        String user = WebSecurity.verifyToken(token);

        if (user != null) {
            ApplicationUser userObject = userService.findUserByUserName(user);
            if (userObject != null) {
                userObject.setPassword(";)");
            }

            return userObject;
        }

        return null;
    }
}
