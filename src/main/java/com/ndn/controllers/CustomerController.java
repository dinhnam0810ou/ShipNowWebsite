/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.mservice.config.Environment;
import com.mservice.enums.RequestType;
import com.mservice.models.PaymentResponse;
import com.mservice.processor.CreateOrderMoMo;
import com.mservice.shared.utils.LogUtils;
import com.ndn.pojos.Auction;
import com.ndn.pojos.Customer;
import com.ndn.pojos.Product;
import com.ndn.pojos.Promotion;
import com.ndn.pojos.ShipOrder;
import com.ndn.pojos.Shipper;
import com.ndn.service.AuctionService;
import com.ndn.service.CustomerService;
import com.ndn.service.EmailService;
import com.ndn.service.ProductService;
import com.ndn.service.PromotionService;
import com.ndn.service.ShipOderService;
import com.ndn.service.ShipperService;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
@ControllerAdvice
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ShipOderService shipOderService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/addproduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addnewproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute(value = "product") @Valid Product p, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.productService.addProduct(p)) {
                return "redirect:/product";
            }
        }

        return "addnewproduct";
    }
    int auctionIdtemp = 0;
    Double promotiondiscounttemp = 1.0;
    int promotionId = 0;
    boolean payment = false;

    @GetMapping("/customerauction/{auctionId}")
    public String pay(Model model, @PathVariable(value = "auctionId") int auctionId) throws Exception {
        if (promotionId != 0) {
            LogUtils.init();
            String requestId = String.valueOf(System.currentTimeMillis());
            String orderId = String.valueOf(System.currentTimeMillis());
            Auction auction = this.auctionService.getAuctionByAuctionId(auctionId);
            double pricetemp = auction.getPrice() * promotiondiscounttemp;
            String newprice = Integer.toString((int) pricetemp);
            long amount = Long.parseLong(newprice);

            String orderInfo = "Pay With MoMo";
            String returnURL = "/customerauction/" + auctionId;
            String notifyURL = "/customerauction/" + auctionId;

            Environment environment = Environment.selectEnv("dev");
            payment = true;
            PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
            model.addAttribute("url", captureWalletMoMoResponse.getPayUrl());
        } else {
            LogUtils.init();
            String requestId = String.valueOf(System.currentTimeMillis());
            String orderId = String.valueOf(System.currentTimeMillis());
            Auction auction = this.auctionService.getAuctionByAuctionId(auctionId);
            double pricetemp = auction.getPrice();
            String newprice = Integer.toString((int) pricetemp);
            long amount = Long.parseLong(newprice);

            String orderInfo = "Pay With MoMo";
            String returnURL = "/customerauction/" + auctionId;
            String notifyURL = "/customerauction/" + auctionId;
            payment = true;
            Environment environment = Environment.selectEnv("dev");

            PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
            model.addAttribute("url", captureWalletMoMoResponse.getPayUrl());
        }

        auctionIdtemp = auctionId;
        if (promotiondiscounttemp != 1.0) {
            model.addAttribute("dis", promotiondiscounttemp);
            promotiondiscounttemp = 1.0;
        } else {
            model.addAttribute("dis", promotiondiscounttemp);
        }
        model.addAttribute("auctionId", auctionId);
        model.addAttribute("auction", this.auctionService.getAuctionById(auctionId));
        return "pay";
    }

    @ModelAttribute
    public void commonAttr(Model model, String mess) {
        model.addAttribute("mess1", mess);
    }

    @PostMapping("/customerauction/{auctionId}")
    public String addShipOrder(Model model, @PathVariable(value = "auctionId") int auctionId) {
        String message = null;
        if (this.shipOderService.addShipOrder(auctionId, promotionId) != null) {
            Auction auc = this.auctionService.getAuctionByAuctionId(auctionId);

            if (payment == true) {
                ShipOrder order = this.shipOderService.getShipOrderByAuctionId(auctionId);
                this.shipOderService.updatePay(order.getId());
            }
            Shipper shipper = this.shipperService.getShipperById(auc.getShipperId().getId());
            this.emailService.sendSimpleMessage(shipper.getEmail(), "Thông báo đấu giá được chọn",
                    "Đấu giá của bạn đã được khác hàng chọn vào lúc " + new Date() + " .Hãy nhanh chóng liên lạc với khách hàng");

            for (Auction a : this.shipperService.getListShipperNotChoose(auc.getProductId(), shipper)) {
                this.emailService.sendSimpleMessage(a.getShipperId().getEmail(), "Thông báo đấu giá không được chọn", "Đấu giá " + auc.getProductId().getProductname() + " của bạn bị khách hàng từ chối");
            }
            message = "101";
            commonAttr(model, message);
            promotionId = 0;
            return "redirect:/";
        } else {
            message = "102";
            commonAttr(model, message);
        }
        return "pay";
    }

    @GetMapping("/customerpromotion")
    public String customerpromotion(Model model,
            @RequestParam(value = "code", required = false) String code) {
        if (code != null && auctionIdtemp != 0) {
            Promotion p = this.promotionService.getPromotionByCode(code);
            if (p != null) {
                promotiondiscounttemp = p.getDiscount();
                promotionId = p.getId();
            }
            return "redirect:/customerauction/" + auctionIdtemp;
        }

        model.addAttribute("promotions", this.promotionService.getPromotions());
        return "customerpromotion";
    }

    @GetMapping("/oderofcustomer")
    public String oderofcustomer(Model model, Principal principal, SecurityContextHolder auth) {
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role;
        for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            if (role.equals("ROLE_CUSTOMER")) {
                Customer customer = this.customerService.getCustomerByUserName(principal.getName());
                model.addAttribute("oderofcus", this.shipOderService.listOrderOfCustomer(customer.getId()));
            }
        }

        return "oderofcustomer";
    }


}
