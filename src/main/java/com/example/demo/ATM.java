package com.example.demo;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String name;

    private ATM atm;

    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<User> users;

}
