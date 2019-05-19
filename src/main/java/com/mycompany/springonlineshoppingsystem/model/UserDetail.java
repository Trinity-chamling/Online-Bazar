/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author test
 */
@Entity
@Table(name="userdetail_table")
public class UserDetail implements Serializable {
    
    public static final long serialVersionUID = 1234564L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="userDetail_id")
    private int id;
    
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dob;
    private String image;
    private String username;
    private String password;
    private String active;
    
    //role part. here relation is maintained with UserRole entity or userRole_table
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userDetail")//mappedby is done with the variablemade in userRole entity.
    private UserRole userRole;

    public UserDetail() {
    }

    public UserDetail(String firstname, String lastname, String email, LocalDate dob, String image, String username, String password, String active, UserRole userRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.image = image;
        this.username = username;
        this.password = password;
        this.active = active;
        this.userRole = userRole;
    }

    public UserDetail(int id, String firstname, String lastname, String email, LocalDate dob, String image, String username, String password, String active, UserRole userRole) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.image = image;
        this.username = username;
        this.password = password;
        this.active = active;
        this.userRole = userRole;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
    
    
}
