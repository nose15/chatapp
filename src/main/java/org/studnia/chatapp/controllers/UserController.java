package org.studnia.chatapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.studnia.chatapp.dtos.user.UserRequestDTO;
import org.studnia.chatapp.dtos.user.UserResponseDTO;
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
    public ResponseEntity<UserResponseDTO> getSingleUser(@PathVariable String id) {
        UserResponseDTO foundUser = userService.getSingleUser(id);

        if (foundUser != null) {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<List<UserResponseDTO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Void> registerUser(@RequestBody UserRequestDTO newUser) {
        userService.registerUser(newUser);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
