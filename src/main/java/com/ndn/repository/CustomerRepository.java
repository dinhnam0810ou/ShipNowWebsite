/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.Customer;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface CustomerRepository {
     Customer getCustomerById(int id);
}
