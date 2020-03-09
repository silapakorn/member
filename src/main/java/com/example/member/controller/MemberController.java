package com.example.member.controller;

import com.example.member.config.JwtTokenUtil;
import com.example.member.model.*;
import com.example.member.service.MemberService;
import com.example.member.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Member member) {
        LOG.info("Start MemberController.register method");
        List<String> error = memberService.validate(member);
        if (error.isEmpty()) {
            memberService.save(member);
            return ResponseEntity.ok("Successfully");
        } else {
            ErrorResponse errorResponse = new ErrorResponse(error, HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/info")
    public Member getInfo() {
        LOG.info("Start MemberController.getInfo method");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            UserDetails user = (UserDetails) auth.getPrincipal();
            String username = user.getUsername();
            return memberService.findByUserName(username);
        } else {
            return null;
        }
    }

}
