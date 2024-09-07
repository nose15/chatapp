package org.studnia.chatapp.services.auth;

import org.studnia.chatapp.dtos.auth.AuthRequestDTO;

public interface AuthService {
    String login(AuthRequestDTO authDTO) throws IllegalArgumentException;
    void logout();
    void logoutAll();
}