package com.example.member.service;

import org.springframework.stereotype.Service;

@Service
public interface JwtTokenService {
    String createToken(String username, String password) throws Exception;
}
