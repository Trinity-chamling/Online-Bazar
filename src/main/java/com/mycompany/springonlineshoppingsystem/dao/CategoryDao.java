/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.dao;

import com.mycompany.springonlineshoppingsystem.model.Category;
import java.util.List;

/**
 *
 * @author test
 */
public interface CategoryDao {
    
    public void insert(Category c);
    
    public List<Category> selectAll();
    
    public Category selectById(int id);
    
    public void update(Category c);
    
    public void delete(int id);
}
