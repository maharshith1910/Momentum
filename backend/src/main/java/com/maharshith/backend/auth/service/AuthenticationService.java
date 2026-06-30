package com.maharshith.backend.auth.service;

import com.maharshith.backend.auth.dto.LoginRequestDTO;
import com.maharshith.backend.auth.dto.LoginResponseDTO;

public interface AuthenticationService {

    LoginResponseDTO login(LoginRequestDTO request);

}
