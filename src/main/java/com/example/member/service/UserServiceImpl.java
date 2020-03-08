package com.example.member.service;

import com.example.member.model.Member;
import com.example.member.model.User;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public User findByUsername(String username) {
        Member member = memberRepository.findByUsername(username);
        return new User(member);
    }
}
