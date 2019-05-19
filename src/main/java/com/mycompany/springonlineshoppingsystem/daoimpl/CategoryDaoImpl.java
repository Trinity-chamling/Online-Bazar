/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.daoimpl;

import com.mycompany.springonlineshoppingsystem.dao.CategoryDao;
import com.mycompany.springonlineshoppingsystem.model.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author test
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void insert(Category c) {
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.persist(c);
       session.getTransaction().commit();
       session.close();
    }

    @Override
    public List<Category> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Category> catl = session.createQuery("FROM Category").list();
        session.close();
        return catl;
    }

    @Override
    public Category selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Category c = session.find(Category.class, id);
        session.close();
        return c;        
    }

    @Override
    public void update(Category c) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(c);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Category c = new Category();
        c.setId(id);
        session.remove(c);
        session.getTransaction().commit();
        session.close();
    }
    
}
