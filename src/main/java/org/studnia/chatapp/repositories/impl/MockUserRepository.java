package org.studnia.chatapp.repositories.impl;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockUserRepository implements UserRepository {
    List<UserDTO> users = new ArrayList<>();

    @Override
    public List<UserDTO> getAll() {
        return users;
    }

    @Override
    public UserDTO getById(int id) {
        for (var user : users) {
            if (user.id == id) return user;
        }

        return null;
    }

    @Override
    public void create(UserDTO newUser) {
        users.add(newUser);
    }

    @Override
    public void delete(int id) {
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
