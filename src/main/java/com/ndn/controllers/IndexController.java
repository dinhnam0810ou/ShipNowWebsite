/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Product;
import com.ndn.service.ProductService;
import com.ndn.service.ShipperService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
@PropertySource("classpath:messages.properties")
public class IndexController {
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private Environment env;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/listshipper")
    public String listshipper(Model model,@RequestParam Map<String,String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shippers", this.shipperService.getShippers(params, page));
        model.addAttribute("shipperCounter", this.shipperService.countShipper());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "listshipper";
    }
   
}
