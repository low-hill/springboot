package com.example.customvalidation.controller;

import com.example.customvalidation.dto.UserDto;
import com.example.customvalidation.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    @PostMapping("/user")
    public ResponseEntity addUser(@Valid @RequestBody UserDto request){
        User user = new User();
        return ResponseEntity.ok(user);
    }
}
