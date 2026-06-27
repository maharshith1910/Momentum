package com.maharshith.backend.service;

import com.maharshith.backend.repository.UserRepository;
import com.maharshith.backend.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
