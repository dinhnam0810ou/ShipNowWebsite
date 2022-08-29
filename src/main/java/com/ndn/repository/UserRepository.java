/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.User;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface UserRepository {
    User getUserByUsername(String username);
    boolean addUser(User user);
    void updateRole(String role,int userid);
    void updatePassword(String password,int userid);
}
