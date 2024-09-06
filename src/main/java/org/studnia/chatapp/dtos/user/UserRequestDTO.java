package org.studnia.chatapp.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class UserRequestDTO {
    @NonNull
    public final String email;

    @NonNull
    public final String password;

    public String name;
    public String phoneNumber;

    public UserRequestDTO(
            @NonNull @JsonProperty("email") String email,
            @NonNull @JsonProperty("password") String password,
            @JsonProperty("name") String name,
            @JsonProperty("phoneNumber") String phoneNumber
    ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
