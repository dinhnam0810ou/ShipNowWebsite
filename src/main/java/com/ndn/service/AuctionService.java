/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service;

import com.ndn.pojos.Auction;
import java.util.List;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface AuctionService {

    Auction addAuction(double price, int productId);

    List<Object[]> getAuctionByShipperId(int shipperId);

    List<Object[]> getAuctionByCustomerId(int customerId);

    List<Object[]> getAuctionById(int auctionId);

    Auction getAuctionByAuctionId(int auctionId);

    boolean deleteAuction(int id);
      List<Auction> getAuctions();
}
