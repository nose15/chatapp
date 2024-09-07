package org.studnia.chatapp.services.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studnia.chatapp.dtos.auth.AuthRequestDTO;
import org.studnia.chatapp.models.User;
import org.studnia.chatapp.repositories.user.UserRepository;
import org.studnia.chatapp.services.auth.AuthService;

import java.util.Optional;

@Service
public class DevelopmentAuthService implements AuthService {
    private final UserRepository userRepository;

    @Autowired
    public DevelopmentAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(AuthRequestDTO authDTO) throws IllegalArgumentException {
        Optional<User> userRes = userRepository.findByEmail(authDTO.email);
        if (!userRes.isPresent()) {
            throw new IllegalArgumentException("No user with such email exists");
        }
        User user = userRes.get();
        if (!user.checkPassword(authDTO.password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        return "69420";
    }

    @Override
    public void logout() {

    }

    @Override
    public void logoutAll() {

    }
}
