package com.example.pfecompagnemailling.DTO.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String role;
    private String login ;
}
