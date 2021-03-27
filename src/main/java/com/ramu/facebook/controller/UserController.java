package com.ramu.facebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.service.UserService;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) throws JsonProcessingException, UserException {
        return userService.addUser(userDTO);
    }

    @PostMapping
    public UserDTO getUser(@RequestBody UserDTO userDTO) throws JsonProcessingException, UserException {
        return userService.getUser(userDTO);
    }
}
