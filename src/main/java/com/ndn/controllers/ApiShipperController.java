/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Shipper;
import com.ndn.service.AuctionService;
import com.ndn.service.ShipperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nguyen Dinh Nam
 */
@RestController
@RequestMapping("/api")
public class ApiShipperController {
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private ShipperService shipppService;

    @GetMapping("/shippers")
    public ResponseEntity<List<Shipper>> list() {
        return new ResponseEntity<>(this.shipppService.getShippers(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/shippers/{shipperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "shipperId") int id) {
        this.shipppService.deleteShipper(id);
    }

   
}
