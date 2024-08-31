package org.studnia.chatapp.services.user;
import org.studnia.chatapp.dtos.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getSingleUser(int id);

    void registerUser(UserDTO newUser);

    void deleteUser(int id);
}
