/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.ndn.googleservice.UserGoogleDto;
import com.ndn.pojos.User;
import com.ndn.repository.UserRepository;
import com.ndn.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username!!!");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public boolean addUser(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        user.setActive(1);
        user.setUserRole("ROLE_CUSTOMER");
        user.setDate(new Date());
        return this.userRepository.addUser(user);
    }

    @Override
    public void updateRole(String role, int userid) {
        this.userRepository.updateRole(role, userid);
    }

    @Override
    public void updatePassword(String password, int userid) {
        this.userRepository.updatePassword(password, userid);
    }

    @Override
    public boolean addUserRoleShipper(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        user.setActive(1);
        user.setUserRole("ROLE_SHIPPER");
        user.setDate(new Date());
        return this.userRepository.addUser(user);
    }

}
