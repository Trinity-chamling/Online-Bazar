/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.model;

import java.time.LocalDate;

/**
 *
 * @author test
 */
public class UserDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dob;
    private String image;
    private String username;
    private String password;
    private String authority;
    private String active;

    public UserDTO() {
    }

    public UserDTO(String firstname, String lastname, String email, LocalDate dob, String image, String username, String password, String authority, String active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.image = image;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.active = active;
    }

    public UserDTO(int id, String firstname, String lastname, String email, LocalDate dob, String image, String username, String password, String authority, String active) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.image = image;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    
    
    
}
