/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author test
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mycompany.springonlineshoppingsystem")
public class WebMVCConfig implements WebMvcConfigurer{
    
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver vr 
                = new InternalResourceViewResolver();
        
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        
        return vr;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/resources/**")//this is url for resource
                .addResourceLocations("/resources/","/other_resources/")//and this will enable the above url to find the resources to apply
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver mr = new CommonsMultipartResolver();
        mr.setMaxUploadSize(10000000L);
        return mr;
    }
    
    @Bean
    public PasswordEncoder bcryptEncoder(){
        return new BCryptPasswordEncoder();
    }
}
