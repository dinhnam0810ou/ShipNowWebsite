/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.ShipOrder;
import java.util.List;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface ShipOrderRepository {

    List<Object[]> listOrder();

    ShipOrder addShipOrder(ShipOrder shipOrder);

    List<Object[]> listOrderOfCustomer(int customerId);

    List<Object[]> listOrderOfShipper(int shipperId);
    void updateShipDate(int shiporderId);
}
