package com.belajar.userapi.service;

import com.belajar.userapi.exception.EmailAlreadyExistsException;
import com.belajar.userapi.exception.UserNotFoundException;
import com.belajar.userapi.model.User;
import com.belajar.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        return userRepository.save(user);
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // update user
    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    // Delete by ID
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    // search by name
    public List<User> searchUsersByName(String keyword) {
        return userRepository.findByNameContainingIgnoreCase(keyword);
    }

    // Check if email exists
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // Check if name exists
    public boolean nameExists(String name) {
        return userRepository.existsByName(name);
    }

}
