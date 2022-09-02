/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.ndn.pojos.Auction;
import com.ndn.pojos.ShipOrder;
import com.ndn.repository.AuctionRepository;
import com.ndn.repository.PromotionRepository;
import com.ndn.repository.ShipOrderRepository;
import com.ndn.service.PromotionService;
import com.ndn.service.ShipOderService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class ShipOderServiceImpl implements ShipOderService{
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private ShipOrderRepository shipOrderRepository;
    @Override
    public List<Object[]> listOrder() {
        return this.shipOrderRepository.listOrder();
    }

    @Override
    public ShipOrder addShipOrder(int auctionId,int promotionId) {
        ShipOrder order = new ShipOrder();
        order.setOrderdate(new Date());
        order.setShipdate(null);
        order.setAuctionId(this.auctionRepository.getAuctionByAuctionId(auctionId));
        order.setPromotionId(this.promotionRepository.getPromotionById(promotionId));
        return this.shipOrderRepository.addShipOrder(order);
    }

    @Override
    public List<ShipOrder> listOrderOfCustomer(int customerId) {
        return this.shipOrderRepository.listOrderOfCustomer(customerId);
    }

    @Override
    public List<ShipOrder> listOrderOfShipper(int shipperId) {
        return this.shipOrderRepository.listOrderOfShipper(shipperId);
    }

    @Override
    public void updateShipDate(int shiporderId) {
        this.shipOrderRepository.updateShipDate(shiporderId);
    }

    @Override
    public ShipOrder getShipOrderById(int shiporderId) {
        return this.shipOrderRepository.getShipOrderById(shiporderId);
    }

    @Override
    public void updatePay(int shiporderId) {
         this.shipOrderRepository.updatePay(shiporderId);
    }

    @Override
    public ShipOrder getShipOrderByAuctionId(int auctionId) {
        return this.shipOrderRepository.getShipOrderByAuctionId(auctionId);
    }

    
    
}
