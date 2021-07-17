package com.example.demo;

import com.example.demo.controller.ApplicationController;

import com.example.demo.service.Service;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ControllerTest {

    @Autowired
    private MockMvc webMvcTest;

    @MockBean
    private Service service;

    @Test
    public void init() throws Exception {
        Mockito.doNothing().when(service).print();
        webMvcTest.perform(MockMvcRequestBuilders.
                get("/root/hello/5").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Ankit")));

    }


}
