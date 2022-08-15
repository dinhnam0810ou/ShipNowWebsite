/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Customer;
import com.ndn.repository.CustomerRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public Customer getCustomerById(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Customer.class, id);
    }
    
}
