/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Product;
import com.ndn.pojos.Shipper;
import com.ndn.repository.AuctionRepository;
import com.ndn.repository.ProductRepository;
import com.ndn.repository.ShipperRepository;
import com.ndn.service.AuctionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class AuctionServiceImpl implements AuctionService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public Auction addAuction(double price, int productId) {
        Product p = this.productRepository.getProductById(productId);
        Shipper s = this.shipperRepository.getShipperById(3);
        Auction a = new Auction();
        a.setPrice(price);
        a.setDate(new Date());
        a.setProductId(p);
        a.setShipperId(s);
        return this.auctionRepository.addAuction(a);
    }  
}
