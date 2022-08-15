/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.ndn.repository.ShipOrderRepository;
import com.ndn.service.ShipOderService;
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
    private ShipOrderRepository shipOrderRepository;
    @Override
    public List<Object[]> listOrder() {
        return this.shipOrderRepository.listOrder();
    }
    
}
