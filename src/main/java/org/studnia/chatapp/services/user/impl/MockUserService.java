package org.studnia.chatapp.services.user.impl;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.services.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockUserService implements UserService {
    private final List<UserDTO> users = new ArrayList<>();

    @Override
    public List<UserDTO> getAllUsers() {
        return users;
    }

    @Override
    public UserDTO getSingleUser(int id) {
        for (var user : users) {
            if (user.id == id) return user;
        }

        return null;
    }

    @Override
    public void createUser(UserDTO newUser) {
        users.add(newUser);
    }

    @Override
    public void deleteUser(int id) {
        UserDTO userToBeRemoved = null;

        for (var user : users) {
            if (user.id == id) {
                userToBeRemoved = user;
                break;
            }
        }

        users.remove(userToBeRemoved);
    }
}
