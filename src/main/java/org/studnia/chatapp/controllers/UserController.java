package org.studnia.chatapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.services.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable int id) {
        UserDTO foundUser = userService.getSingleUser(id);

        if (foundUser != null) {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO newUser) {
        userService.registerUser(newUser);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
