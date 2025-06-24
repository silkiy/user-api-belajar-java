package com.belajar.userapi.controller;

import com.belajar.userapi.model.User;
import com.belajar.userapi.service.UserService;
import com.belajar.userapi.exception.UserNotFoundException;
import com.belajar.userapi.dto.UserRequestDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequestDTO request) {
        User updated = new User();
        updated.setName(request.getName());
        updated.setEmail(request.getEmail());
        return ResponseEntity.ok(userService.updateUser(id, updated));
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // Search user by name
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(userService.searchUsersByName(keyword));
    }

    // Check if email exists
    @GetMapping("/exists/email")
    public ResponseEntity<Boolean> emailExists(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.emailExists(email));
    }

    // Check if name exists
    @GetMapping("/exists/name")
    public ResponseEntity<Boolean> nameExists(@RequestParam("name") String name) {
        return ResponseEntity.ok(userService.nameExists(name));
    }
}
