package com.example.gefangshuai.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gefangshuai on 2015/11/3.
 */
@Entity
@Table(name = "users")
public class User {
    public long id;
    public String email;
    public String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
