package com.example.demo;



import javax.persistence.*;
import java.util.Set;

@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String name;


    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

