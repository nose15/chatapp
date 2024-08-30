package org.studnia.chatapp.controllers;

import org.apache.catalina.User;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.services.user.UserService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserDTO> allUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("")
    public void createUser(@RequestBody UserDTO newUser) {
        userService.createUser(newUser);
    }
}

