/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.daoimpl;

import com.mycompany.springonlineshoppingsystem.dao.UserRegisterDao;
import com.mycompany.springonlineshoppingsystem.model.UserDTO;
import com.mycompany.springonlineshoppingsystem.model.UserDetail;
import com.mycompany.springonlineshoppingsystem.model.UserRole;
import java.util.ArrayList;
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
public class UserRegisterDaoImpl implements UserRegisterDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public boolean insert(UserDTO user) {
        
        boolean status = false;
        
        try(Session session = sessionFactory.openSession()){
            
            session.beginTransaction();
            
            UserDetail uD = new UserDetail();
            UserRole uR = new UserRole();
            
            uD.setFirstname(user.getFirstname());
            uD.setLastname(user.getLastname());
            uD.setEmail(user.getEmail());
            uD.setDob(user.getDob());
            uD.setImage(user.getImage());
            uD.setUsername(user.getUsername());
            uD.setPassword(user.getPassword());
            if(user.getAuthority().equals("ROLE_USER")){
                uD.setActive("1");
            }else{
                uD.setActive("0");
            }
            
            uR.setRole(user.getAuthority());
            
            uD.setUserRole(uR);
            uR.setUserDetail(uD);
            
            session.persist(uD);
            session.getTransaction().commit();
            
            status = true;            
        }
        
        return status;
    }

    @Override
    public ArrayList<UserDTO> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDTO selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserDTO user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
