package org.studnia.chatapp.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studnia.chatapp.dtos.user.UserRequestDTO;
import org.studnia.chatapp.dtos.user.UserResponseDTO;
import org.studnia.chatapp.models.User;
import org.studnia.chatapp.repositories.user.UserRepository;
import org.studnia.chatapp.services.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DevelopmentUserService implements UserService {

    UserRepository userRepository;

    @Autowired
    public DevelopmentUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = new ArrayList<>();

        for (User user : userRepository.findAll()) {
            users.add(UserResponseDTO.fromEntity(user));
        }

        return users;
    }

    @Override
    public UserResponseDTO getSingleUser(String id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return UserResponseDTO.fromEntity(userData.get());
        }

        return null;
    }

    @Override
    public void registerUser(UserRequestDTO userData) {
        User newUser = new User();
        newUser.setEmail(userData.email);
        newUser.setPasswordHash(userData.password);

        userRepository.save(newUser);
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            userRepository.delete(userData.get());
        }
    }
}
