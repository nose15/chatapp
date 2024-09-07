package org.studnia.chatapp.services.auth;

import org.studnia.chatapp.dtos.auth.AuthRequestDTO;
import org.studnia.chatapp.dtos.auth.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(AuthRequestDTO authDTO);
    void logout();
    void logoutAll();
}