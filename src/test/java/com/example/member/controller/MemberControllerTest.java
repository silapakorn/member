//package com.example.member.controller;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import com.example.member.model.Member;
//import com.example.member.service.MemberService;
//import com.example.member.service.MemberServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import com.example.member.MemberApplication;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = MemberApplication.class)
//@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Transactional
//public class MemberControllerTest {
//
//    private MockMvc mockMvc;
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    @Autowired
//    private MemberService memberService = new MemberServiceImpl();
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//
//    }
//
//    @Test
//    public void verifySaveToDo() throws Exception {
//        Member member = new Member();
//        member.setUsername("somchai_m84");
//        member.setPassword("password");
//        member.setEmail("somchai@gmail.com");
//        member.setFirstName("somchai");
//        member.setLastName("Madee");
//        member.setPhoneNumber("0123456789");
//        member.setAddress("211 Moo.10 Bankok");
//        member.setPostCode("12000");
//        member.setSalary((double) 50000);
//        mockMvc.perform(post("/member/register", 42L)
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(member)))
//                .andExpect(content().string("Successfully"))
//                .andExpect(status().isOk());
//    }
//
//}