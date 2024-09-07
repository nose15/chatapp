package org.studnia.chatapp.dtos.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class AuthRequestDTO {
    @NonNull
    public final String email;
    @NonNull
    public final String password;

    public AuthRequestDTO(
            @NonNull @JsonProperty("email") String email,
            @NonNull @JsonProperty("password") String password
            ) {
        this.email = email;
        this.password = password;
    }
}
