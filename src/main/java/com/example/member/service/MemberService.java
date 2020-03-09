package com.example.member.service;

import com.example.member.model.Member;

import java.util.List;

public interface MemberService {
    void save(Member member);

    Member findByUserName(String username);

    List<String> validate(Member member);
}
