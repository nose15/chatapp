package org.studnia.chatapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.studnia.chatapp.dtos.auth.AuthRequestDTO;
import org.studnia.chatapp.dtos.auth.AuthResponseDTO;
import org.studnia.chatapp.services.auth.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDTO) {
        AuthResponseDTO responseDTO = authService.login(authRequestDTO);

        if (responseDTO.success) {
            return new ResponseEntity<AuthResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<AuthResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }
}
