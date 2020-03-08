package com.example.member.controller;

import com.example.member.repository.MemberRepository;
import com.example.member.service.MemberService;
import com.example.member.service.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HelloServiceMockTest {

//    @Mock
//    private MemberRepository helloRepository;

    @InjectMocks // auto inject helloRepository
    private MemberService memberService = new MemberServiceImpl();

//    @BeforeEach
//    void setMockOutput() {
//        when(memberService.get2()).thenReturn("Hello Mockito From Repository");
//    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals("Hello", memberService.get());
    }

}