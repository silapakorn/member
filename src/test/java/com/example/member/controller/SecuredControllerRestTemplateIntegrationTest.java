package com.example.member.controller;

import com.example.member.service.DataService;
import com.example.member.service.JwtTokenService;
import com.example.member.service.JwtTokenServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SecuredControllerRestTemplateIntegrationTest {
 
    @Autowired
    private TestRestTemplate template;

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    private JwtTokenService jwtTokenService = new JwtTokenServiceImpl();
 
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
//        ResponseEntity<String> result = template.getForEntity("/member/info", String.class);
//        Assert.assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
//        when(jwtTokenService.createToken("111","2222")).thenReturn("");
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
        assertEquals("24", jwtTokenService.createToken("somchai","password"));
    }
}