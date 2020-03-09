package com.example.member.controller;

import com.example.member.model.JwtRequest;
import com.example.member.model.JwtResponse;
import com.example.member.service.CustomUserDetailsService;
import com.example.member.service.JwtTokenService;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        String token = jwtTokenService.createToken(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
