package com.example.demo.controller;

import com.example.demo.controller.json.Hello;
import com.example.demo.controller.json.Parent;
import com.example.demo.exception.ServiceException;
import com.example.demo.proxy.FeignClient;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;


@Validated
@RestController
@RequestMapping("/root")
public class ApplicationController {

    private Service service;
    private FeignClient feignClient;

    @Autowired
    public void setFeignClient(FeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/hello/{id}")
    public Hello hello(@PathVariable(required = true, value = "id") @Min(value = 3, message = "min value should be 3") int count) throws ServiceException {
        Hello hello = new Hello();
        hello.setWelcome("Welcome Ankit!");
        service.print();
        return hello;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/hello/request")
    public Hello helloRequest(@RequestParam(required = true, value = "id") @Min(value = 3, message = "min value should be 3") int count) {
        Hello hello = new Hello();
        hello.setWelcome("Welcome Ankit!");
        return hello;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/root/post")
    public Parent postParent(@RequestBody @Valid Parent parent){
        return parent;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/root/proxy")
    public Parent postProxy(@RequestBody @Valid Parent parent){
        return feignClient.fetchParent(parent);
    }

}
