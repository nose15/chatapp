package org.studnia.chatapp.repositories.user;

import org.studnia.chatapp.dtos.UserDTO;

import java.util.List;

public interface UserRepository {
    public List<UserDTO> getAll();
    public UserDTO getById(int id);
    public void create(UserDTO newUser);
    public void delete(int id);
}
