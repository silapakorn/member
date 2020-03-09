package com.example.member.controller;


import com.example.member.MemberApplication;
import com.example.member.model.ErrorResponse;
import com.example.member.model.Member;
import com.example.member.service.DataService;
import com.example.member.service.MemberService;
import com.example.member.service.MemberServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = MemberApplication.class)
public class HelloServiceMockTest {

    private MockMvc mockMvc;

//    @Mock
//    private TestRestTemplate template;

    @MockBean
    DataService dataServiceMock;

    @Autowired
    private WebApplicationContext context;

    @InjectMocks // auto inject helloRepository
    private MemberService memberService = new MemberServiceImpl();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addEmployeeTest() throws Exception {
        Member member = new Member();
        member.setUsername("somchai_m84");
        member.setPassword("password");
        member.setEmail("somchai@gmail.com");
        member.setFirstName("somchai");
        member.setLastName("Madee");
        member.setPhoneNumber("0123456789");
        member.setAddress("211 Moo.10 Bankok");
        member.setPostCode("12000");
        member.setSalary((double) 50000);
        String jsonRequest = objectMapper.writeValueAsString(member);
        MvcResult result = mockMvc.perform(post("/member/register").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        Assert.assertEquals(resultContent, "Successfully");
    }

    @Test
    public void registerRequireField() throws Exception {
        Member member = new Member();
        String jsonRequest = objectMapper.writeValueAsString(member);
        MvcResult result = mockMvc.perform(post("/member/register").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        ErrorResponse response = objectMapper.readValue(resultContent, ErrorResponse.class);
        String errorStr = "[\"email must not be null\"" +
                ",\"firstName must not be null\"" +
                ",\"lastName must not be null\"" +
                ",\"password must not be null\"" +
                ",\"phoneNumber must not be null\"" +
                ",\"salary must not be null\"" +
                ",\"username must not be null\"]";
        List<String> errors = response.getErrors();
        Collections.sort(errors);
        Assert.assertEquals(objectMapper.writeValueAsString(errors), errorStr);
    }

    @Test
    public void registerBussinessValidate() throws Exception {
        Member member = new Member();
        member.setUsername("somchai_m84");
        member.setPassword("password");
        member.setEmail("somchai@gmail.com");
        member.setFirstName("somchai");
        member.setLastName("Madee");
        member.setPhoneNumber("0123456789");
        member.setAddress("211 Moo.10 Bankok");
        member.setPostCode("12000");
        member.setSalary((double) 5000);
        String jsonRequest = objectMapper.writeValueAsString(member);
        MvcResult result = mockMvc.perform(post("/member/register").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        ErrorResponse response = objectMapper.readValue(resultContent, ErrorResponse.class);
        String errorStr = "[\"Salary less than 15,000 cannot register.\"]";
        List<String> errors = response.getErrors();
        Collections.sort(errors);
        Assert.assertEquals(objectMapper.writeValueAsString(errors), errorStr);
    }

//    @Test
//    public void shouldNotAllowAccessToUnauthenticatedUsers() {
//        ResponseEntity<String> result = template.getForEntity("/member/info", String.class);
//        Assert.assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
//    }

    @Test
    public void testFindTheGreatestFromAllData() {
        when(dataServiceMock.retrieveMember()).thenReturn(new Member());
//        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }

}