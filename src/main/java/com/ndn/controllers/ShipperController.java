/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.service.CommentService;
import com.ndn.service.ShipperService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
@PropertySource("classpath:messages.properties")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private CommentService commentService;
     @Autowired
    private Environment env;
    @GetMapping("/{shipperId}")
    public String detail(Model model,@PathVariable(value = "shipperId") int shipperId,
            @RequestParam(required = false) Map<String,String> params
           ){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shipper", this.shipperService.getShipperById(shipperId));
        model.addAttribute("comments", this.commentService.getCommentByShipperId(shipperId, page));
        model.addAttribute("countComment", this.commentService.countComment(shipperId));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        
        return "shipper-detail";
    }
   
}
