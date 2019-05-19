/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.dao;

import com.mycompany.springonlineshoppingsystem.model.UserDTO;
import java.util.ArrayList;

/**
 *
 * @author test
 */
public interface UserRegisterDao {
    public boolean insert(UserDTO user);
    
    public ArrayList<UserDTO> selectAll();
    
    public UserDTO selectById(int id);
    
    public boolean update(UserDTO user);
}
