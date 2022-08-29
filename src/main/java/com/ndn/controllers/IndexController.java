/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Product;
import com.ndn.service.CustomerService;
import com.ndn.service.EmailService;
import com.ndn.service.ProductService;
import com.ndn.service.ShipperService;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@ControllerAdvice
@Controller
@PropertySource("classpath:messages.properties")
public class IndexController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model, Principal principal, SecurityContextHolder auth) {
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role;
        for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            if (role.equals("ROLE_CUSTOMER")) {
                model.addAttribute("customer", this.customerService.getCustomerByUserName(principal.getName()));
            }
            if (role.equals("ROLE_SHIPPER")) {
                model.addAttribute("shipper", this.shipperService.getShipperByUserName(principal.getName()));
            }
        }
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/")
    public String usersendmail(@RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "email",required = false) String email,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "message",required = false) String message) {
       this.emailService.userSendMail(email, "Feedback of "+name+" "+phone, message);
        return "index";
    }

    @GetMapping("/listshipper")
    public String listshipper(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shippers", this.shipperService.getShippers(params, page));
        model.addAttribute("shipperCounter", this.shipperService.countShipper());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "listshipper";
    }

}
