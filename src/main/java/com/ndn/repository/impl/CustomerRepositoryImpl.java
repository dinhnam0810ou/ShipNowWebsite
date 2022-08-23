/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Comment;
import com.ndn.pojos.Customer;
import com.ndn.pojos.User;
import com.ndn.repository.CustomerRepository;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public Customer getCustomerByUserName(String username) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Customer Where userId In (From User  Where username=:name)");
        q.setParameter("name", username);
        return (Customer) q.getSingleResult();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

  
}
