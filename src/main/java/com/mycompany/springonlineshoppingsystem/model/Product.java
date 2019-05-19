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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author test
 */
@Entity
@Table(name="product_table")
public class Product implements Serializable {
    
    private static final long serialVersionUID = 100805L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pro_id")
    private int id;
    
    @Column(name="pro_name")
    private String name;
    
    @Column(name="pro_description")
    private String description;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="cat_id", nullable=false)
    private Category category;
       
    @Column(name="pro_image")
    private String image;
    
    @Column(name="pro_brand")
    private String brand;
    
    @Column(name="pro_color")
    private String color;
    
    @Column(name="pro_price")
    private double price;

    public Product() {
    }

    public Product(String name, String description, Category category, String image, String brand, String color, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public Product(int id, String name, String description, Category category, String image, String brand, String color, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
