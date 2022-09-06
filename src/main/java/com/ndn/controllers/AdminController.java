/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Promotion;
import com.ndn.pojos.Shipper;
import com.ndn.service.CustomerService;
import com.ndn.service.ProductService;
import com.ndn.service.PromotionService;
import com.ndn.service.ShipOderService;
import com.ndn.service.ShipperService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShipOderService shipOderService;
    @Autowired
    private ShipperService shipperService;

    @GetMapping("/")
    public String adminindex() {
        return "adminindex";
    }

    @GetMapping("/shippers")
    public String shipper(Model model) {
        model.addAttribute("shipper", new Shipper());
        return "shipper";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
       if(sId!=0){
           model.addAttribute("editshipper", this.shipperService.getShipperById(sId));
       }
    }
    int sId=0;

    @GetMapping("/shippers/{shipperId}")
    public String adminupdateShipper(Model model, @PathVariable(value = "shipperId") int shipperId) {
        sId = shipperId;
        model.addAttribute("editshipper", this.shipperService.getShipperById(shipperId));
        return "adminupdate";
    }

    @PostMapping("/shippers/{shipperId}")
    public String updateprofile(Model model,
            @ModelAttribute(value = "editshipper") @Valid Shipper shipper,
            BindingResult result) {
        System.out.println(shipper.getId());
        if (!result.hasErrors()) {
            if (shipper != null) {
                if (this.shipperService.updateShipper(shipper)) {
                    model.addAttribute("update", "Update Success");
                } else {
                    model.addAttribute("update", "Update Fail");
                }
            }
        }
        return "adminupdate";
    }

    @PostMapping("/shippers")
    public String add(Model model, @ModelAttribute(value = "shipper") @Valid Shipper s,
            BindingResult r) {
        if (!r.hasErrors()) {
            if (this.shipperService.addShipper(s)) {
                return "redirect:/admin/";
            } else {
                model.addAttribute("errMsg", "Fail");
            }
        }
        return "shipper";
    }

    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(value = "quarter", required = false, defaultValue = "0") int quarter,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("orderstat", this.shipperService.countOrderByShipper());
        model.addAttribute("revenue", this.shipperService.revenue(quarter, year));
        return "stats";
    }

    @GetMapping("/order")
    public String oder(Model model) {
        model.addAttribute("orders", this.shipOderService.listOrder());
        return "order";
    }

    @GetMapping("/proNotauc")
    public String productnotaucion(Model model) {
        model.addAttribute("products", this.productService.productNotAuction());
        return "productnotaucion";
    }

    @GetMapping("/promotion")
    public String promotions(Model model) {
        model.addAttribute("promotions", this.promotionService.getPromotions());
        model.addAttribute("promotion", new Promotion());
        return "promotion";
    }

}
