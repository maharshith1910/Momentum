package com.maharshith.backend.auth.controller;

import com.maharshith.backend.auth.dto.LoginRequestDTO;
import com.maharshith.backend.auth.dto.LoginResponseDTO;
import com.maharshith.backend.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request
    ) {

        return ResponseEntity.ok(authenticationService.login(request));

    }

}
