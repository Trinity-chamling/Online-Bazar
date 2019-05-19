/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.service;

import com.mycompany.springonlineshoppingsystem.model.Category;
import java.util.List;

/**
 *
 * @author test
 */
public interface CategoryService {
    
    public void addCategory(Category c);
    
    public List<Category> getAllCategory();
    
    public Category getCategoryById(int id);
    
    public void updateCategory(Category c);
    
    public void deleteCategory(int id);
}
