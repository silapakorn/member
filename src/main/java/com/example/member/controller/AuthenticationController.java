package com.example.member.controller;

import com.example.member.model.JwtRequest;
import com.example.member.model.JwtResponse;
import com.example.member.service.CustomUserDetailsService;
import com.example.member.service.JwtTokenService;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    @InjectMocks
    private JwtTokenService jwtTokenService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final String token = jwtTokenService.createToken(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
