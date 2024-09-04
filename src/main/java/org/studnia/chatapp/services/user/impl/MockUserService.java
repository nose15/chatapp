package org.studnia.chatapp.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.models.UserData;
import org.studnia.chatapp.repositories.user.UserRepository;
import org.studnia.chatapp.services.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockUserService implements UserService {
    UserRepository userRepository;

    @Autowired
    public MockUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        for (UserData user : userRepository.findAll()) {
            users.add(convertToDto(user));
        }

        return users;
    }

    @Override
    public UserDTO getSingleUser(long id) {
        Optional<UserData> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return convertToDto(userData.get());
        }

        return null;
    }

    @Override
    public void registerUser(UserDTO newUser) {
        UserData userData = new UserData();
        userData.setEmail(newUser.name);

        userRepository.save(userData);
    }

    @Override
    public void deleteUser(long id) {
        Optional<UserData> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            userRepository.delete(userData.get());
        }
    }

    private UserDTO convertToDto(UserData userData) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = userData.getId();
        userDTO.name = userData.getEmail();

        return userDTO;
    }
}
