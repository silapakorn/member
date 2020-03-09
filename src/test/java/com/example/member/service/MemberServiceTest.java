package com.example.member.service;

import com.example.member.model.Member;
import com.example.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService = new MemberServiceImpl();

    @Test
    public void whenFindByUsername_thenReturnMember() {
        // given
        Member member = new Member();
        member.setId(1L);
        member.setUsername("somchai_m100");
        member.setPassword("password");
        member.setEmail("somchai@gmail.com");
        member.setFirstName("somchai");
        member.setLastName("Madee");
        member.setPhoneNumber("0123456789");
        member.setAddress("211 Moo.10 Bankok Thailand");
        member.setPostCode("12000");
        member.setSalary((double) 50000);
        doReturn(member).when(memberRepository).findByUsername(any());

        // when
        Member actualMember = memberService.findByUserName(any());

        // then
        assertThat(actualMember).isEqualTo(member);
    }
}
