package com.example.member.repository;

import com.example.member.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    public Member findByUsername(String username);

}
