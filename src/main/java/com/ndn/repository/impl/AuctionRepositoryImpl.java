/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Auction;
import com.ndn.repository.AuctionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Repository
@Transactional
public class AuctionRepositoryImpl implements AuctionRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public Auction addAuction(Auction auction) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
           session.save(auction);
           return auction;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
