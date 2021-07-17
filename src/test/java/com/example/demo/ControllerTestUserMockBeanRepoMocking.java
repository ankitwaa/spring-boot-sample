package com.example.demo;

import com.example.demo.controller.ApplicationController;
import com.example.demo.exception.ServiceException;
import com.example.demo.proxy.FeignClient;
import com.example.demo.repo.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.Service;
import com.example.demo.service.ServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ControllerTestUserMockBeanRepoMocking {

    @org.springframework.boot.test.context.TestConfiguration
    static class TestConfiguration{
        @Bean
        public Service getService(){
            return new ServiceImpl();
        }
    }

    @Autowired
    private Service service;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepo(){
        User user = new User();
        user.setId("123");
        user.setEmail("anky@gmail.com");
        testEntityManager.persistAndFlush(user);

        Optional<User> user1 = userRepository.findById("123");
        Assert.assertEquals(user1.get().getEmail(), "anky@gmail.com");
    }


}
