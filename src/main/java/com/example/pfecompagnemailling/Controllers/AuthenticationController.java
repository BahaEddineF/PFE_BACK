package com.example.pfecompagnemailling.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pfecompagnemailling.DTO.auth.AuthenticationRequest;
import com.example.pfecompagnemailling.DTO.auth.AuthenticationResponse;
import com.example.pfecompagnemailling.Services.Auth.IAuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody AuthenticationRequest request
    ) {
        System.out.println("enter method ");
      return ResponseEntity.ok(service.login(request));
    }
    
}
