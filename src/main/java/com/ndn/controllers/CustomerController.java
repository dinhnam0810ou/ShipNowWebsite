/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Product;
import com.ndn.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
public class CustomerController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/addproduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addnewproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute(value = "product") @Valid Product p, BindingResult rs) {
        if (this.productService.addProduct(p)) {
            return "redirect:/product";
        }
        return "addnewproduct";
    }
}
