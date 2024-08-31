package org.studnia.chatapp.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.repositories.UserRepository;
import org.studnia.chatapp.repositories.impl.MockUserRepository;
import org.studnia.chatapp.services.user.UserService;

import java.util.List;

@Service
public class MockUserService implements UserService {
    UserRepository userRepository;

    @Autowired
    public MockUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public UserDTO getSingleUser(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void registerUser(UserDTO newUser) {
        userRepository.create(newUser);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }
}
