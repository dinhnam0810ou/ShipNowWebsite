/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service;

import com.ndn.pojos.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
     boolean addUser(User user);
      void upadeRole(String role,int userid);
}
