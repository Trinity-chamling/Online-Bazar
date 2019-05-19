/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springonlineshoppingsystem.configuration;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author test
 */
@Configuration
@EnableTransactionManagement
public class DbConfig {
    
    @Bean
    public DriverManagerDataSource getDataSource(){
        
      DriverManagerDataSource dmds = new  DriverManagerDataSource();
      dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dmds.setUrl("jdbc:mysql://localhost:3306/spring_oss");
      dmds.setUsername("root");
      dmds.setPassword("");
      
      return dmds;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory
                = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("com.mycompany.springonlineshoppingsystem.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        
        return sessionFactory;
    }
    
    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = 
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        
        return transactionManager;
    }
    
    private final Properties hibernateProperties(){
        
        Properties hibernateProperties = new Properties();
        
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        
        return hibernateProperties;
    }
    
}
