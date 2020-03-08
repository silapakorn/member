package com.example.member.service;

import com.example.member.model.User;

public interface UserService {
    User findByUsername(String username);
}
