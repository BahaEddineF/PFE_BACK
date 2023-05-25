package com.example.pfecompagnemailling.Services.Auth;

import com.example.pfecompagnemailling.DTO.auth.AuthenticationRequest;
import com.example.pfecompagnemailling.DTO.auth.AuthenticationResponse;

public interface IAuthenticationService {
    AuthenticationResponse login(AuthenticationRequest request);
    
}
