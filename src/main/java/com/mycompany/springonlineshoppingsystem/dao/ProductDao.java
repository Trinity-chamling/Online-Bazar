/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.dao;

import com.mycompany.springonlineshoppingsystem.model.Product;
import java.util.List;

/**
 *
 * @author test
 */
public interface ProductDao {
    
    public void insert(Product p);
    
    public List<Product> selectAll();
    
    public Product selectById(int id);
    
    public void update(Product p);
    
    public void delete(int id);
}
