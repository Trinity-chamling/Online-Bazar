/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.service;

import com.mycompany.springonlineshoppingsystem.model.UserDTO;
import java.util.ArrayList;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */
public interface UserRegisterService {
   
    public boolean uploadImage(MultipartFile image);
    
    public boolean saveNewUser(UserDTO user);
    
    public ArrayList<UserDTO> getAllUsers();
    
    public UserDTO getUserById(int id);
    
    public boolean editStatus(int id);
}
