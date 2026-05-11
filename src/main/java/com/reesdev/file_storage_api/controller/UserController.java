package com.reesdev.file_storage_api.controller;

import com.reesdev.file_storage_api.dto.UserResponse;
import com.reesdev.file_storage_api.entity.User;
import com.reesdev.file_storage_api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> getALlUsers()
    {
        return userService.getAllUsers();
    }
}
