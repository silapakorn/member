package com.example.member.service;

import com.example.member.model.Member;
import org.springframework.stereotype.Repository;

@Repository
public class DataService {
    public int[] retrieveAllData() {
        // Some dummy data
        // Actually this should talk to some database to get all the data
        return new int[]{1, 2, 3, 4, 5};
    }

    public Member retrieveMember() {
    	Member member = new Member();
    	member.setAddress("");
        return member;
    }
}