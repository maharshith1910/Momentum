package com.maharshith.backend.service;

import com.maharshith.backend.repository.UserRepository;
import com.maharshith.backend.entity.User;
import org.springframework.stereotype.Service;
import com.maharshith.backend.dto.*;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        User user = new User();

        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);
    }
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();    }
    public Optional<UserResponseDTO> getUserById(Long id){
        return userRepository.findById(id).map(this::mapToDTO);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    private UserResponseDTO mapToDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
        public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());

            User updatedUser = userRepository.save(user);

            return mapToDTO(updatedUser);
    }

}
