/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Customer;
import com.ndn.pojos.ShipOrder;
import com.ndn.pojos.Shipper;
import com.ndn.service.AuctionService;
import com.ndn.service.CommentService;
import com.ndn.service.CustomerService;
import com.ndn.service.EmailService;
import com.ndn.service.ShipOderService;
import com.ndn.service.ShipperService;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
@PropertySource("classpath:messages.properties")
public class ShipperController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private ShipOderService shipOderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private Environment env;

    @GetMapping("/{shipperId}")
    public String detail(Model model, @PathVariable(value = "shipperId") int shipperId,
            @RequestParam(required = false) Map<String, String> params
    ) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shipper", this.shipperService.getShipperById(shipperId));
        model.addAttribute("comments", this.commentService.getCommentByShipperId(shipperId, page));
        model.addAttribute("countComment", this.commentService.countComment(shipperId));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "shipper-detail";
    }

    @GetMapping("/myauction")
    public String myauction(Model model, Principal principal, SecurityContextHolder auth) {
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role;
        for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            if (role.equals("ROLE_SHIPPER")) {
                Shipper s = this.shipperService.getShipperByUserName(principal.getName());
                model.addAttribute("auctions", this.auctionService.getAuctionByShipperId(s.getId()));
            }
        }
        return "shipperauction";
    }

    @GetMapping("/customerauction")
    public String customerauction(Model model, Principal principal, SecurityContextHolder auth) {
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role;
        for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            if (role.equals("ROLE_CUSTOMER")) {
                Customer c = this.customerService.getCustomerByUserName(principal.getName());
                model.addAttribute("auctions", this.auctionService.getAuctionByCustomerId(c.getId()));
            }
        }
        return "customerauction";
    }
    @GetMapping("/oderofshipper")
    public String oderofshipper(Model model, Principal principal, SecurityContextHolder auth){
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role;
        for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            if (role.equals("ROLE_SHIPPER")) {
                Shipper s = this.shipperService.getShipperByUserName(principal.getName());
                model.addAttribute("oderofship", this.shipOderService.listOrderOfShipper(s.getId()));
            }
        }
        return "oderofshipper";
    }
    @GetMapping("/oderofshipper/{shiporderId}")
    public String updateshipdate(@PathVariable(value = "shiporderId") int shiporderId){
        this.shipOderService.updateShipDate(shiporderId);
        this.shipOderService.updatePay(shiporderId);
        ShipOrder order = this.shipOderService.getShipOrderById(shiporderId);
        this.emailService.sendSimpleMessage(order.getAuctionId().getProductId().getCustomerId().getEmail(), "Thông báo giao hàng", "Đơn hàng đã được giao về địa chỉ yêu cầu");
        return "index";
    }
}
