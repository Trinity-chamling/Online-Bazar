/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.service;

import com.mycompany.springonlineshoppingsystem.model.Product;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */
public interface ProductService {
    
    public void addProduct(Product p);
    
    public List<Product> getAllProduct();
    
    public boolean uploadImage(MultipartFile image);
    
    public Product getProductById(int id);
    
    public void updateProduct(Product p);
    
    public void deleteProduct(int id);
}
