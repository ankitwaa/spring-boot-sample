package com.example.demo.controller;

import com.example.demo.controller.json.Hello;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;


@Validated
@RestController
@RequestMapping("/root")
public class ApplicationController {

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/hello/{id}")
    public Hello hello(@PathVariable(required = true, value = "id") @Min(value = 3, message = "min value should be 3") int count) {
        Hello hello = new Hello();
        hello.setWelcome("Welcome Ankit!");
        return hello;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/hello/request")
    public Hello helloRequest(@RequestParam(required = true, value = "id") @Min(value = 3, message = "min value should be 3") int count) {
        Hello hello = new Hello();
        hello.setWelcome("Welcome Ankit!");
        return hello;
    }


}
