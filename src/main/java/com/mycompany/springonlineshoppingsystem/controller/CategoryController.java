/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.controller;

import com.mycompany.springonlineshoppingsystem.model.Category;
import com.mycompany.springonlineshoppingsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author test
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
   
    @GetMapping("/add")
    public String addCategoryPage(){
        return "admin/category";
    }
    
    @GetMapping("/display")
    public String displayCategoryPage(Model model){
        model.addAttribute("display", "true");
        model.addAttribute("categories", categoryService.getAllCategory());
        return "admin/category";
//        return "redirect:/admin/category/display#displayCategory";
    }
    
    @PostMapping("/add")
    public String saveCategory(@RequestParam("cname") String name,
                               @RequestParam("cdescription") String description){
        
        Category c = new Category();
        c.setName(name);
        c.setDescription(description);
        
        categoryService.addCategory(c);
        
        return "redirect:/admin/category/display#showCategory";        
    }
    
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
        
        Category c = categoryService.getCategoryById(id);
        model.addAttribute("category", c);
        model.addAttribute("edit", "true");
        model.addAttribute("categories", categoryService.getAllCategory());
        
        return "admin/category";
    }
    
    @PostMapping("/update")
    public String updateCategory(@RequestParam("cid") int id,
                                 @RequestParam("cname") String name,
                                 @RequestParam("cdescription") String description
                                 ){
        
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        c.setDescription(description);
        
        categoryService.updateCategory(c);
        
        return "redirect:/admin/category/display#showCategory";
    }
  
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category/display#showCategory";
    }
    
   
}
