package com.example.demo.controller.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Parent {
    @NotNull
    @NotEmpty
    private String name;

    @Min(value = 1, message = "min age should be greater than 1")
    @Max(value = 100, message = "max age should not be greater than 150")
    private int age;

    @Valid
    @NotNull
    @JsonProperty("child")
    private Child child;
}
