/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Comment;
import com.ndn.pojos.Customer;
import com.ndn.pojos.Product;
import com.ndn.pojos.Shipper;
import com.ndn.repository.AuctionRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
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
public class AuctionRepositoryImpl implements AuctionRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Auction addAuction(Auction auction) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(auction);
            return auction;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object[]> getAuctionByShipperId(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rA = q.from(Auction.class);
        Root rP = q.from(Product.class);

        q.where(b.equal(rP.get("id"), rA.get("productId")),
                b.equal(rA.get("shipperId"), shipperId));

        q.multiselect(rP.get("productname"), rP.get("image"), rP.get("shipaddress"), rA.get("price"), rA.get("date"),rA.get("id"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getAuctionByCustomerId(int customerId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rP = q.from(Product.class);
        Root rC = q.from(Customer.class);
        Root rA = q.from(Auction.class);
        Root rS = q.from(Shipper.class);

        q.where(b.equal(rP.get("customerId"), rC.get("id")),
                b.equal(rA.get("productId"), rP.get("id")),
                b.equal(rC.get("id"), customerId),
                b.equal(rS.get("id"), rA.get("shipperId")));

        q.multiselect(rP.get("productname"), rP.get("image"), rP.get("shipaddress"), rP.get("createdDate"),
                 rS.get("firstname"), rS.get("lastname"), rA.get("price"), rA.get("date"), rA.get("id"),rP.get("active"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getAuctionById(int auctionId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rA =q.from(Auction.class);
        Root rS = q.from(Shipper.class);
        Root rP = q.from(Product.class);
        
        q.where(b.equal(rS.get("id"), rA.get("shipperId")),
                b.equal(rP.get("id"), rA.get("productId")),
                b.equal(rA.get("id"), auctionId));
        q.multiselect(rP.get("productname"),rP.get("shipaddress"),rS.get("firstname"), rS.get("lastname"),rA.get("price"),rA.get("id"));
        
         Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Auction getAuctionByAuctionId(int auctionId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Auction.class, auctionId);
    }

    @Override
    public boolean deleteAuction(int id) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Auction a = session.get(Auction.class, id);
            session.delete(a);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Auction> getAuctions() {
         Session session = this.sessionFactory.getObject().getCurrentSession();
         Query q = session.createQuery("From Auction");
         return q.getResultList();
    }

}
