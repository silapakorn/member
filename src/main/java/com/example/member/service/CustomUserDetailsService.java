package com.example.member.service;

import com.example.member.config.UserPrincipal;
import com.example.member.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        LOG.debug("Start CustomUserDetailsService.loadUserByUsername method username: {}", username);
        // Let people login with either username or email
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user invalid");
        }
        return UserPrincipal.create(user);
    }
}