package com.example.member.service;

public interface JwtTokenService {
    String createToken(String username, String password) throws Exception;
}
