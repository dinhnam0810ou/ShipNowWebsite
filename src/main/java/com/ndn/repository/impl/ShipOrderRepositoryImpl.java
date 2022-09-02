/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Customer;
import com.ndn.pojos.Product;
import com.ndn.pojos.Promotion;
import com.ndn.pojos.ShipOrder;
import com.ndn.pojos.Shipper;
import com.ndn.repository.ShipOrderRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class ShipOrderRepositoryImpl implements ShipOrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> listOrder() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(ShipOrder.class);
        Root rA = q.from(Auction.class);
        Root rS = q.from(Shipper.class);
        Root rP = q.from(Product.class);

        q.where(b.equal(rO.get("auctionId"), rA.get("id")),
                b.equal(rS.get("id"), rA.get("shipperId")),
                b.equal(rP.get("id"), rA.get("productId")));
        q.multiselect(rO.get("id"), rS.get("firstname"), rS.get("lastname"), rP.get("productname"), rO.get("orderdate"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public ShipOrder addShipOrder(ShipOrder shipOrder) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(shipOrder);
            return shipOrder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShipOrder> listOrderOfCustomer(int customerId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM ShipOrder where auctionId.id in (select id from Auction where productId.id in (select id from Product where customerId.id =:cusId))");
        q.setParameter("cusId", customerId);
        return q.getResultList();
    }

    @Override
    public List<ShipOrder> listOrderOfShipper(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM ShipOrder where auctionId.id in (select id from Auction where shipperId.id =:shipId)");
        q.setParameter("shipId", shipperId);
        return q.getResultList();
    }

    @Override
    public void updateShipDate(int shiporderId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Update ShipOrder set shipdate=:date where id=:shiporderId");
        q.setParameter("date", new Date());
        q.setParameter("shiporderId", shiporderId);
        int r = q.executeUpdate();
    }

    @Override
    public ShipOrder getShipOrderById(int shiporderId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(ShipOrder.class, shiporderId);
    }

    @Override
    public void updatePay(int shiporderId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Update ShipOrder set pay=:p where id=:shiporderId");
        q.setParameter("p", 1);
        q.setParameter("shiporderId", shiporderId);
        int r = q.executeUpdate();
    }

    @Override
    public ShipOrder getShipOrderByAuctionId(int auctionId) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
         Query q = session.createQuery("From ShipOrder where auctionId.id=:aid");
         q.setParameter("aid", auctionId);
         return (ShipOrder) q.getSingleResult();
    }

}
