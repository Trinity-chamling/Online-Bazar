/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.controller;

import com.mycompany.springonlineshoppingsystem.model.Product;
import com.mycompany.springonlineshoppingsystem.service.CategoryService;
import com.mycompany.springonlineshoppingsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */
@Controller
@RequestMapping("/admin/product")
public class ProductController {
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/add")
    public String addProductpage(Model model){
//        model.addAttribute("edit", "false");
        model.addAttribute("categories", categoryService.getAllCategory());
        return "admin/product";
    }
    
    @PostMapping("/add")
    public String addProduct(@RequestParam("pname") String name,
                             @RequestParam("pdescription") String description,
                             @RequestParam("pcategory") int category,
                             @RequestParam("pimage") MultipartFile image,
                             @RequestParam("pbrand") String brand,
                             @RequestParam("pcolor") String color,
                             @RequestParam("pprice") double price,
                             Model model){
        
        Product p = new Product();
        
        if(!productService.uploadImage(image)){
            model.addAttribute("uploaderror", "image upload failure");
            return "admin/product";
        }

       
        p.setName(name);
        p.setDescription(description);
        p.setCategory(categoryService.getCategoryById(category));//category service is used to store category with id from the form.
        p.setImage(image.getOriginalFilename());
        p.setBrand(brand);
        p.setColor(color);
        p.setPrice(price);
        
        productService.addProduct(p);
        return "redirect:/admin/product/display#showProduct";
        
    }
    
    @GetMapping("/display")
    public String displayProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("display", "true");
        model.addAttribute("categories", categoryService.getAllCategory());
        return "admin/product";
    }
    
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Product p = productService.getProductById(id);
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("product", p);
        model.addAttribute("edit", "true");
        model.addAttribute("products", productService.getAllProduct());
        
        return "admin/product";
    }
    
    @PostMapping("/update")
    public String updateProduct(
                             @RequestParam("pid") int id,                 
                             @RequestParam("pname") String name,
                             @RequestParam("pdescription") String description,
                             @RequestParam("pcategory") int category,
                             @RequestParam("pimage") MultipartFile image,
                             @RequestParam("pbrand") String brand,
                             @RequestParam("pcolor") String color,
                             @RequestParam("pprice") double price,
                             Model model){
        Product p = new Product();
        
        if(!productService.uploadImage(image)){
            model.addAttribute("uploaderror", "image upload failure");
            return "admin/product";
        }

       
        p.setId(id);
        p.setName(name);
        p.setDescription(description);
        p.setCategory(categoryService.getCategoryById(category));//category service is used to store category with id from the form.
        p.setImage(image.getOriginalFilename());
        p.setBrand(brand);
        p.setColor(color);
        p.setPrice(price);
        
        productService.updateProduct(p);
        return "redirect:/admin/product/display#showProduct";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "redirect:/admin/product/display#showProduct";
    }
}
