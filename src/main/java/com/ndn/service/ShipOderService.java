package com.ndn.service;

import com.ndn.pojos.Auction;
import com.ndn.pojos.ShipOrder;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nguyen Dinh Nam
 */
public interface ShipOderService {

    List<Object[]> listOrder();

    ShipOrder addShipOrder(int auctionId, int promotionId);

    List<ShipOrder> listOrderOfCustomer(int customerId);

    List<ShipOrder> listOrderOfShipper(int shipperId);

    void updateShipDate(int shiporderId);
     void updatePay(int shiporderId);
    ShipOrder getShipOrderById(int shiporderId);
     ShipOrder getShipOrderByAuctionId(int auctionId);
}
