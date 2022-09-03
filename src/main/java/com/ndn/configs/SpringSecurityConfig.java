/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndn.handlers.LoginHandler;
import com.ndn.handlers.LogoutHandler;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ndn.controllers",
    "com.ndn.repository",
    "com.ndn.service",
    "com.ndn.handlers"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginHandler loginHandler;
    @Autowired
    private LogoutHandler logoutHanlder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "da1xygjae",
                        "api_key", "594162664828989",
                        "api_secret", "ZOD-FN0IJ18P_ror89q-gEdOgoU",
                        "secure", true));
        return cloudinary;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().successHandler(loginHandler);
        http.logout().logoutSuccessHandler(logoutHanlder);
        
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/myauction").access("hasRole('ROLE_SHIPPER')")
                .antMatchers("/customerauction").access("hasRole('ROLE_CUSTOMER')")
                .antMatchers("/oderofcustomer").access("hasRole('ROLE_CUSTOMER')")
                .antMatchers("/oderofshipper").access("hasRole('ROLE_SHIPPER')")
                .antMatchers("/addproduct").access("hasRole('ROLE_CUSTOMER')")
                .antMatchers("/customerauction/**").access("hasRole('ROLE_CUSTOMER')")
                .antMatchers("/customerpromotion").access("hasRole('ROLE_CUSTOMER')")
                .antMatchers("/oderofshipper/**").access("hasRole('ROLE_SHIPPER')");
                
        
        http.csrf().disable();
    }
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("shipnowonline@gmail.com");
        mailSender.setPassword("hfmeobkayaqpthrl");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
