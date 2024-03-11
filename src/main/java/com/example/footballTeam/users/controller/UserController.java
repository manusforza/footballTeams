package com.example.footballTeam.users.controller;

import com.example.footballTeam.users.model.User;
import com.example.footballTeam.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/")
    public String deleteUser(@RequestBody User user) {return userService.deleteUser(user);}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
}
