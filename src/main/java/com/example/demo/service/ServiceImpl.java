package com.example.demo.service;

import com.example.demo.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Override
    public void print() throws ServiceException {
      log.info("print method called");
    }
}
