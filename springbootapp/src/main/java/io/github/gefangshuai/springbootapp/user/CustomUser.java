package io.github.gefangshuai.springbootapp.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gefangshuai on 2015/11/3.
 */
@Entity
@Table(name = "users")
public class CustomUser{
    private long id;
    private String email;
    private String name;
    private String role;
    private String password;

    public CustomUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomUser(long id) {
        this.id = id;
    }

    public CustomUser(String email, String name) {
        this.email = email;
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
