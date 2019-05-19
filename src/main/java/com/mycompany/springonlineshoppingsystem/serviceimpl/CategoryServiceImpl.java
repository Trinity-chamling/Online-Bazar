/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.serviceimpl;

import com.mycompany.springonlineshoppingsystem.dao.CategoryDao;
import com.mycompany.springonlineshoppingsystem.model.Category;
import com.mycompany.springonlineshoppingsystem.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author test
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void addCategory(Category c) {
        categoryDao.insert(c);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.selectAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.selectById(id);
    }

    @Override
    public void updateCategory(Category c) {
        categoryDao.update(c);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDao.delete(id);
    }
    
}
