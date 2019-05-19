/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.serviceimpl;

import com.mycompany.springonlineshoppingsystem.dao.ProductDao;
import com.mycompany.springonlineshoppingsystem.model.Product;
import com.mycompany.springonlineshoppingsystem.service.ProductService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    ProductDao productDao;
    
    private static final String UPLOAD_DIR = "C:\\Users\\test\\Desktop\\Spring_O-B_images";//desktop path
    
    @Override
    public void addProduct(Product p) {
       productDao.insert(p); 
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.selectAll();
    }

    @Override
    public Product getProductById(int id) {
        return productDao.selectById(id);
    }

    @Override
    public void updateProduct(Product p) {
        productDao.update(p);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.delete(id);
    }

    @Override
    public boolean uploadImage(MultipartFile image) {
        boolean status = false;//this does not have to go to the Dao.... the work is done here to upload the image
         
         File dir = new File(UPLOAD_DIR + File.separator + "Products");
         if(!dir.exists()){
             dir.mkdirs();
         }
         
         String filename = image.getOriginalFilename();
         File uploaddir = new File(dir+File.separator+filename);
         
         try{
             image.transferTo(uploaddir);
             status = true;
         }catch(IOException | IllegalStateException e){
             System.out.println(e);
         }
         
         return status;
    }
    
}
