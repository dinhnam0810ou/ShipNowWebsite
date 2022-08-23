/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndn.pojos.Customer;
import com.ndn.pojos.User;
import com.ndn.repository.CustomerRepository;
import com.ndn.service.CustomerService;
import com.ndn.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(int id) {
        return this.customerRepository.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByUserName(String username) {
        return this.customerRepository.getCustomerByUserName(username);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userService.getUserByUsername(authentication.getName());
            Map result = this.cloudinary.uploader().upload(customer.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) result.get("secure_url");
            customer.setAvatar(img);
            customer.setUserId(user);
            return this.customerRepository.addCustomer(customer);
        } catch (Exception e) {
            System.err.println("ADD CUSTOMER " + e.getMessage());
        }
        return false;
    }

}
