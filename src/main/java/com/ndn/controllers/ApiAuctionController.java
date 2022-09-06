/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import com.ndn.pojos.Auction;
import com.ndn.service.AuctionService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nguyen Dinh Nam
 */
@RestController

public class ApiAuctionController {

    @Autowired
    private AuctionService auctionService;

    @PostMapping(path = "/api/add-auction", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Auction> addAuction(@RequestBody Map<String, String> params) {
        try {
            Double price = Double.parseDouble(params.get("price"));
            int productId = Integer.parseInt(params.get("productId"));
            Auction a = this.auctionService.addAuction(price, productId);
            return new ResponseEntity<>(a, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/auctions")
    public ResponseEntity<List<Auction>> listauction() {
        return new ResponseEntity<>(this.auctionService.getAuctions(), HttpStatus.OK);
    }

    @DeleteMapping("/api/myauction/{auctionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteauction(@PathVariable(value = "auctionId") int id) {
        this.auctionService.deleteAuction(id);
    }
}
