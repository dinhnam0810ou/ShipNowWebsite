/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Promotion;
import com.ndn.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping("/admin/promotion")
    public String addPromotion(@ModelAttribute(value = "promotion") Promotion promotion) {
        if (this.promotionService.addPromotion(promotion)) {
            return "redirect:/";
        }
        return "promotion";
    }
}
