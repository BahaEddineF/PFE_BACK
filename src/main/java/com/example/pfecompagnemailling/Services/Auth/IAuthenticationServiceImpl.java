package com.example.pfecompagnemailling.Services.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.pfecompagnemailling.DTO.auth.AuthenticationRequest;
import com.example.pfecompagnemailling.DTO.auth.AuthenticationResponse;
import com.example.pfecompagnemailling.Entities.User;
import com.example.pfecompagnemailling.Repository.UserRepository;
import com.example.pfecompagnemailling.Security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IAuthenticationServiceImpl implements IAuthenticationService{
    private  final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository repository ;
    @Override 
    public AuthenticationResponse login(AuthenticationRequest request) {
       
            authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
            );
       
    

        User user = repository.findByLogin(request.getLogin()).get();
        System.out.println("user " + user.getEmail());
        final String token = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
        .accessToken(token)
        .role(user.getRole().getLibelle())
        .login(user.getLogin())
        .build();

    }
    
}
