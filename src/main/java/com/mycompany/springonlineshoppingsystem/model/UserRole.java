/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author test
 */
@Entity
@Table(name="userrole_table")
public class UserRole implements Serializable {
    
    public static final long serialVersionUID = 9987969L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="userRole_id")
    private int id;
    
    private String role;
    
    //relation to userDetail_table or userDetail entity.
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="userDetail_id", nullable=false)//joining this column with userDetail_id of UserDetail entity.
    private UserDetail userDetail;

    public UserRole() {
    }

    public UserRole(String role, UserDetail userDetail) {
        this.role = role;
        this.userDetail = userDetail;
    }

    public UserRole(int id, String role, UserDetail userDetail) {
        this.id = id;
        this.role = role;
        this.userDetail = userDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
    
    
}
