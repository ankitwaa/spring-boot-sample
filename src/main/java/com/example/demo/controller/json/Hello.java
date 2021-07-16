package com.example.demo.controller.json;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Hello {

    @JsonProperty("welcome")
    private String welcome;

}
