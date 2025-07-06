package com.example.sales.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.sales.exception.UserAlreadyLoggedOutException;
import com.example.sales.exception.UserExistsException;
import com.example.sales.exception.UserNotFoundException;
import com.example.sales.model.User;
import com.example.sales.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public void createUser(@RequestBody User user) throws UserExistsException {
        userService.signup(user);
    }

    @PostMapping("/login")
    public void logUser(@RequestBody User user) throws UserNotFoundException {
        userService.login(user);
    }

    @PostMapping("/logout")
    public void logOutUser() throws UserAlreadyLoggedOutException {
        userService.logout();
    }

    @PatchMapping("/pass")
    public void changePassword(@RequestBody String password) {
        userService.changePassword(password);
    }

    @PatchMapping("/name")
    public void changeUsername(@RequestBody String username) {
        userService.changeUsername(username);
    }

    @PostMapping("/")
    public Optional<User> getUserById(@RequestBody Long id) {
        return userService.getUserById(id);
    }
}

