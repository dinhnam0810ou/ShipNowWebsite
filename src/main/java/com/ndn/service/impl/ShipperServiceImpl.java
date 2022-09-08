/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndn.pojos.Auction;
import com.ndn.pojos.Product;
import com.ndn.pojos.Shipper;
import com.ndn.pojos.User;
import com.ndn.repository.ShipperRepository;
import com.ndn.service.ShipperService;
import com.ndn.service.UserService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class ShipperServiceImpl implements ShipperService {

    @Autowired
    private UserService userService;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Shipper> getShippers(Map<String, String> params, int page) {
        return this.shipperRepository.getShippers(params, page);
    }

    @Override
    public int countShipper() {
        return this.shipperRepository.countShipper();
    }

    @Override
    public boolean addShipper(Shipper shipper) {
        try {
            Map result = this.cloudinary.uploader().upload(shipper.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) result.get("secure_url");
            shipper.setAvatar(img);
            return this.shipperRepository.addShipper(shipper);
        } catch (IOException ex) {
            System.err.println("ADD SHIPPER " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteShipper(int id) {
        return this.shipperRepository.deleteShipper(id);
    }

    @Override
    public Shipper getShipperById(int id) {
        return this.shipperRepository.getShipperById(id);
    }

    @Override
    public List<Object[]> countOrderByShipper() {
        return this.shipperRepository.countOrderByShipper();
    }

    @Override
    public List<Object[]> revenue(int quarter, int year) {
        return this.shipperRepository.revenue(quarter, year);
    }

    @Override
    public Shipper getShipperByUserName(String username) {
        return this.shipperRepository.getShipperByUserName(username);
    }

    @Override
    public List<Auction> getListShipperNotChoose(Product productId, Shipper shipperIdchoose) {
        return this.shipperRepository.getListShipperNotChoose(productId, shipperIdchoose);
    }

    @Override
    public boolean updateShipper(Shipper shipper) {
        try {
            if (!shipper.getFile().isEmpty()) {
                Map result = this.cloudinary.uploader().upload(shipper.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) result.get("secure_url");
                shipper.setAvatar(img);
                return this.shipperRepository.updateShipper(shipper);
            }
            else
                 return this.shipperRepository.updateShipper(shipper);

        } catch (IOException ex) {
            System.err.println("UPDATE SHIPPER " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean addGgShipper(Shipper shipper) {
        return this.shipperRepository.addShipper(shipper);
    }
}
