package com.ndn.service;


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
     ShipOrder addShipOrder(int auctionId,int promotionId);
       List<Object[]> listOrderOfCustomer(int customerId);
        List<Object[]> listOrderOfShipper(int shipperId);
        void updateShipDate(int shiporderId);
}
