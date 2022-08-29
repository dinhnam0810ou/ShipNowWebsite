/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Customer;
import com.ndn.pojos.Shipper;
import com.ndn.pojos.User;
import com.ndn.service.CustomerService;
import com.ndn.service.EmailService;
import com.ndn.service.ShipperService;
import com.ndn.service.UserService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
@ControllerAdvice
public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private UserService userDetailsService;

    @ModelAttribute
    public void commonAttr(Model model, String mess) {
        model.addAttribute("mess", mess);
    }

    @GetMapping("/forgotpassword")
    public String forgotpassword() {
        return "forgotpassword";
    }
    int code;
    int useridtemp;
    @PostMapping("/forgotpassword")
    public String forgot(Model model, @RequestParam(value = "username", required = false) String username) {

        String errMsg = null;
        try {
            User user = this.userDetailsService.getUserByUsername(username);
            useridtemp = user.getId();
            errMsg = "1";
            commonAttr(model, errMsg);
            Random rand = new Random();
            code = rand.nextInt(100000);
            try {
                Shipper s = this.shipperService.getShipperByUserName(username);
                this.emailService.sendSimpleMessage(s.getEmail(), "Khoi phuc mat khau", "Ma khoi phuc la: " + code);
                return "redirect:/completepassword";
            } catch (Exception e) {
                Customer c = this.customerService.getCustomerByUserName(username);
                this.emailService.sendSimpleMessage(c.getEmail(), "Khoi phuc mat khau", "Ma khoi phuc la: " + code);
                return "redirect:/completepassword";
            }
        } catch (Exception e) {
            errMsg = "Username ko ton tai";
            model.addAttribute("errMsg", errMsg);
        }

        return "forgotpassword";
    }

    @GetMapping("/completepassword")
    public String completepassword() {
        return "completepassword";
    }

    @PostMapping("/completepassword")
    public String complete(Model model,
            @RequestParam(value = "newpassword", required = false) String newpassword,
            @RequestParam(value = "confirmpassword", required = false) String confirmpassword,
            @RequestParam(value = "code", required = false) int codetemp) {
            String errMsg = null;
            if(newpassword.equals(confirmpassword)==true&&codetemp==code){
                this.userService.updatePassword(this.passwordEncoder.encode(newpassword), useridtemp);
                String success = "1";
                commonAttr(model, success);
                return "redirect:/login";
            }
            else
            {
                errMsg = "Mật khẩu không trùng khớp hoặc mã xác nhận không đúng";
                model.addAttribute("errMsg", errMsg);
            }
        return "completepassword";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(Model model, @ModelAttribute(value = "user") User user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addUser(user)) {
                return "redirect:/login";
            }
        } else {
            String errMsg = "Mat khau ko khop";
            model.addAttribute("errMsg", errMsg);
        }
        return "register";
    }

    @GetMapping("/registershipper")
    public String registerShipper(Model model) {
        model.addAttribute("shipper", new Shipper());
        return "registerShipper";
    }

    @PostMapping("/registershipper")
    public String addShipper(@ModelAttribute(value = "shipper") Shipper shipper) {
        if (this.shipperService.addShipper(shipper)) {
            return "redirect:/";
        }
        return "registerShipper";
    }

    @GetMapping("/registercustomer")
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "registerCustomer";
    }

    @PostMapping("/registercustomer")
    public String addCustomer(@ModelAttribute(value = "customer") Customer customer) {
        if (this.customerService.addCustomer(customer)) {
            return "redirect:/";
        }
        return "registerCustomer";
    }
}