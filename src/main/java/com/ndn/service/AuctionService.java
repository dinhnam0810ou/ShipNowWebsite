/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service;

import com.ndn.pojos.Auction;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface AuctionService {
     Auction addAuction(double price,int productId);
}
