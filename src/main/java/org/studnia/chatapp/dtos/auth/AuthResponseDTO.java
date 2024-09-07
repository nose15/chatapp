package org.studnia.chatapp.dtos.auth;

import org.springframework.lang.NonNull;

public class AuthResponseDTO {
    public boolean success;
    public String token;
    public String errorMessage;

    public static AuthResponseDTO success(String token) {
        AuthResponseDTO newAuthDTO = new AuthResponseDTO();
        newAuthDTO.success = true;
        newAuthDTO.token = token;
        return newAuthDTO;
    }

    public static AuthResponseDTO failure(String message) {
        AuthResponseDTO newAuthDTO = new AuthResponseDTO();
        newAuthDTO.success = false;
        newAuthDTO.errorMessage = message;
        return newAuthDTO;
    }

}
