/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.daoimpl;

import com.mycompany.springonlineshoppingsystem.dao.ProductDao;
import com.mycompany.springonlineshoppingsystem.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author test
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void insert(Product p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Product> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> prol = session.createQuery("FROM Product").list();
        session.close();
        return prol;
    }

    @Override
    public Product selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product p = session.find(Product.class, id);
        session.close();
        return p;
    }

    @Override
    public void update(Product p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product p = new Product();
        p.setId(id);
        session.remove(p);
        session.getTransaction().commit();
        session.close();
    }
    
}
