/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.Customer;
import com.ndn.pojos.Shipper;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface CustomerRepository {

    Customer getCustomerById(int id);

    Customer getCustomerByUserName(String username);

    boolean addCustomer(Customer customer);

    boolean updateCustomer(Customer customer);
}
