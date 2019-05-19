/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.controller;

import com.mycompany.springonlineshoppingsystem.model.UserDTO;
import com.mycompany.springonlineshoppingsystem.service.UserRegisterService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */
@Controller
public class FrontendController {
    
    @Autowired
    UserRegisterService userRegisterService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String homepage(){
        return "home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(@RequestParam(value="error", required=false) String error,
                            @RequestParam(value="logout", required=false) String logout,
                            Model model){
        String errorMessage = null;
        
        if(error!=null){
            errorMessage="Username or Password Invalid";
        }
        
        if(logout!=null){
            errorMessage="You have been succesfully Logged out";
        }
        
        model.addAttribute("errorMessage", errorMessage);
        
        return "login";
    }
    
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String registerUserPage(){
        return "register_user";
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String saveNewUser(  @RequestParam("firstname") String firstname,
                                @RequestParam("lastname") String lastname,
                                @RequestParam("email") String email,
                                @RequestParam("dob") String dob,
                                @RequestParam("image") MultipartFile image,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("cpassword") String cpassword,
                                @RequestParam("authority") String authority,
                                Model model){
        
        if(!password.equals(cpassword)){
            model.addAttribute("passwordError", "Password Mismatch!");
            return "register_user";
//            return "redirect:/register";
        }
        
        if(!userRegisterService.uploadImage(image)){
            model.addAttribute("uploadError", "Image upload failed!");
            return "register_user";
        }
        
        UserDTO user = new UserDTO();
        
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setDob(LocalDate.parse(dob));
        user.setImage(image.getOriginalFilename());
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthority(authority);
        
        if(!userRegisterService.saveNewUser(user)){
            model.addAttribute("registerError", "New User Register Failed!!");
            return "register_user";
        }
        
        model.addAttribute("Congrulation", "You are registered...Login to proceed !!");
        return "login";
    }
    
}
