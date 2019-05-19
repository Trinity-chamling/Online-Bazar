/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author test
 */
@Controller
public class AdminController {
   
    @RequestMapping(value={"/admin/home","/admin/dashboard"}, method=RequestMethod.GET)
    public String adminDashboardPage(){
        return "admin/admindashboard";
    }
}
