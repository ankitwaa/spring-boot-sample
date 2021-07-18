package com.example.demo;

import com.example.demo.controller.ApplicationController;
import com.example.demo.proxy.FeignClient;
import com.example.demo.service.Service;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest({ApplicationController.class})
public class WebMvcMockBean {

    @Autowired
    private MockMvc webMvcTest;

    @MockBean
    private Service service;

    @MockBean
    private FeignClient feignClient;

    @Test
    public void init() throws Exception {
        webMvcTest.perform(MockMvcRequestBuilders.
                get("/root/hello/5").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Ankit")));

        Mockito.verify(service, Mockito.times(1)).print();
    }

    @Test
    public void initTest() throws Exception {
        webMvcTest.perform(MockMvcRequestBuilders.
                get("/root/hello/5"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.welcome").value("Welcome Ankit!"));
    }


}
