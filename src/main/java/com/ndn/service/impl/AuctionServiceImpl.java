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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public Auction addAuction(double price, int productId) {
        Product p = this.productRepository.getProductById(productId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Auction a = new Auction();
        a.setPrice(price);
        a.setDate(new Date());
        a.setProductId(p);
        a.setShipperId(this.shipperRepository.getShipperByUserName(authentication.getName()));
        return this.auctionRepository.addAuction(a);
    }

    @Override
    public List<Object[]> getAuctionByShipperId(int shipperId) {
        return this.auctionRepository.getAuctionByShipperId(shipperId);
    }

    @Override
    public List<Object[]> getAuctionByCustomerId(int customerId) {
        return this.auctionRepository.getAuctionByCustomerId(customerId);
    }

    @Override
    public List<Object[]> getAuctionById(int auctionId) {
        return this.auctionRepository.getAuctionById(auctionId);
    }

    @Override
    public Auction getAuctionByAuctionId(int auctionId) {
        return this.auctionRepository.getAuctionByAuctionId(auctionId);
    }

    @Override
    public boolean deleteAuction(int id) {
        return this.auctionRepository.deleteAuction(id);
    }

    @Override
    public List<Auction> getAuctions() {
        return this.auctionRepository.getAuctions();
    }

}
