package com.maharshith.backend.auth.service;

import com.maharshith.backend.auth.dto.LoginRequestDTO;
import com.maharshith.backend.auth.dto.LoginResponseDTO;
import com.maharshith.backend.auth.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public AuthenticationServiceImpl(
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ){
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getEmail());

        return new LoginResponseDTO(token);
    }
}