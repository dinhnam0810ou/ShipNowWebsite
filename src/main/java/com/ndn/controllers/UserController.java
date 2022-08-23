/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Customer;
import com.ndn.pojos.Shipper;
import com.ndn.pojos.User;
import com.ndn.service.CustomerService;
import com.ndn.service.ShipperService;
import com.ndn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
public class UserController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private UserService userDetailsService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String addUser(Model model,@ModelAttribute(value = "user") User user){
        if(user.getPassword().equals(user.getConfirmPassword()))
        {
            if(this.userDetailsService.addUser(user)){
                return "redirect:/login";
            }
        }
        else{
            String errMsg = "Mat khau ko khop";
            model.addAttribute("errMsg", errMsg);
        }
        return "register";
    }
    @GetMapping("/registershipper")
    public String registerShipper(Model model){
        model.addAttribute("shipper", new Shipper());
        return "registerShipper";
    }
    @PostMapping("/registershipper")
    public String addShipper(@ModelAttribute(value = "shipper") Shipper shipper){
        if(this.shipperService.addShipper(shipper)){
            return "redirect:/";
        }
        return "registerShipper";
    }
    @GetMapping("/registercustomer")
    public String registerCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "registerCustomer";
    }
    @PostMapping("/registercustomer")
    public String addCustomer(@ModelAttribute(value = "customer") Customer customer){
        if(this.customerService.addCustomer(customer)){
            return "redirect:/";
        }
        return "registerCustomer";
    }
}
