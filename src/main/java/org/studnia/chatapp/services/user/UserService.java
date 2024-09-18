package org.studnia.chatapp.services.user;
import org.studnia.chatapp.dtos.user.UserRequestDTO;
import org.studnia.chatapp.dtos.user.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getSingleUser(String id);

    UserResponseDTO registerUser(UserRequestDTO newUser);

    void deleteUser(String id);
}
