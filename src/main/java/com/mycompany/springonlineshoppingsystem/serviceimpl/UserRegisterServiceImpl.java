/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.serviceimpl;

import com.mycompany.springonlineshoppingsystem.dao.UserRegisterDao;
import com.mycompany.springonlineshoppingsystem.model.UserDTO;
import com.mycompany.springonlineshoppingsystem.service.UserRegisterService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    
    @Autowired
    UserRegisterDao userRegisterDao;
    
    private static final String UPLOAD_DIR = "C://Users//test//Desktop//Spring_O-B_images";

    @Override
    public boolean uploadImage(MultipartFile image) {
        boolean status = false;
        
        //upload a file in a directory.....
        File dir = new File(UPLOAD_DIR + File.separator + "users");        
        if(!dir.exists()){
            dir.mkdir();
        }
        
        String fileName = image.getOriginalFilename();
        File uploadDir = new File(dir+File.separator+fileName);
        
        try{
            image.transferTo(uploadDir);
            status = true;
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        
        return status;
    }

    @Override
    public boolean saveNewUser(UserDTO user) {
        return userRegisterDao.insert(user);
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDTO getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
