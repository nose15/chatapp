package org.studnia.chatapp.dtos.user;

import org.springframework.lang.NonNull;
import org.studnia.chatapp.models.User;

public class UserResponseDTO {
    @NonNull
    public final String id;

    @NonNull
    public final String email;

    public String name;
    public String phoneNumber;

    public UserResponseDTO(@NonNull String id, @NonNull String email) {
        this.id = id;
        this.email = email;
    }

    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(user.getId(), user.getEmail());
    }
}
