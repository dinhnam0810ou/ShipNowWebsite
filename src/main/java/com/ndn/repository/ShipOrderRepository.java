/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.Auction;
import com.ndn.pojos.ShipOrder;
import java.util.List;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface ShipOrderRepository {

    List<Object[]> listOrder();

    ShipOrder addShipOrder(ShipOrder shipOrder);

    List<ShipOrder> listOrderOfCustomer(int customerId);

    List<ShipOrder> listOrderOfShipper(int shipperId);

    void updateShipDate(int shiporderId);

    void updatePay(int shiporderId);

    ShipOrder getShipOrderById(int shiporderId);

    ShipOrder getShipOrderByAuctionId(int auctionId);
}
