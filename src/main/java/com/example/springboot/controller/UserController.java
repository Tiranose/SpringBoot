package com.example.springboot.controller;

import com.example.springboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = List.of(
                new User(1L, "bob@i.ua"),
                new User(2L, "alice@i.ua")
        );
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        String responseMessage = String.format("User created. Id: %s, email: %s", user.getId(), user.getEmail());
        return ResponseEntity.ok(responseMessage);
    }
}
