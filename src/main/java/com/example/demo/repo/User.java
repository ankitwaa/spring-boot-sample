package com.example.demo.repo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="email")
    private String email;
}
