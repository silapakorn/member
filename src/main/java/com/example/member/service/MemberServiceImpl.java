package com.example.member.service;

import com.example.member.model.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void save(Member member) {
        String phoneNumber = member.getPhoneNumber();
        Date curDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String referenceCod = sdf.format(curDate) + phoneNumber.substring(phoneNumber.length() - 4);
        member.setReferenceCod(referenceCod);
        member.setCreateBy(member.getUsername());
        member.setUpdateBy(member.getUsername());
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());
        PasswordEncoder en = new BCryptPasswordEncoder();
        String password = en.encode(member.getPassword());
        member.setPassword(password);
        memberRepository.save(member);
    }

    @Override
    public Member findByUserName(String username) {
        Member member = memberRepository.findByUsername(username);
        if(member !=null) {
            member.setPassword(null);
            Double salary = member.getSalary();
            String typeClassify = null;
            if (salary > 50000) {
                typeClassify = "Platinum";
            } else if (salary >= 30000) {
                typeClassify = "Gold";
            } else if (salary >= 15000) {
                typeClassify = "Silver";
            }
            member.setTypeClassify(typeClassify);
        }
        return member;
    }

    @Override
    public List<String> validate(Member member) {
        List<String> errors = new ArrayList<>();
        Member curMember = this.findByUserName(member.getUsername());
        if(curMember != null) {
            errors.add("Username already exists.");
        }
        if (member.getSalary() < 15000) {
            errors.add("Salary less than 15,000 cannot register.");
        }
        return errors;
    }

    @Override
    public Integer exists(String username) {
       List<String> list = new ArrayList<>();
       list.add("Hello");
        return list.size();
    }

    @Override
    public String get() {
        return "Hello";
    }

    @Override
    public String get2() {
        return "Hello";
    }
}
