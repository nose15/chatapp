package org.studnia.chatapp.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;
import org.studnia.chatapp.sec.validators.email.ValidEmail;
import org.studnia.chatapp.sec.validators.password.PasswordMatches;

@PasswordMatches
public class UserRequestDTO {
    @ValidEmail
    @NonNull
    @NotNull
    @NotEmpty
    public final String email;

    @NonNull
    @NotNull
    @NotEmpty
    public final String password;

    @NonNull
    @NotNull
    @NotEmpty
    public final String matchingPassword;

    public String name;
    public String phoneNumber;

    public UserRequestDTO(
            @NonNull @JsonProperty("email") String email,
            @NonNull @JsonProperty("password") String password,
            @NonNull @JsonProperty("matchingPassword") String matchingPassword,
            @JsonProperty("name") String name,
            @JsonProperty("phoneNumber") String phoneNumber
    ) {
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
