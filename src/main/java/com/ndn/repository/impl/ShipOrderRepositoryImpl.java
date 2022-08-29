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
    public List<Object[]> listOrderOfCustomer(int customerId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(ShipOrder.class);
        Root rA = q.from(Auction.class);
        Root rS = q.from(Shipper.class);
        Root rP = q.from(Product.class);
        Root rPromo = q.from(Promotion.class);
        Root rC = q.from(Customer.class);

        q.where(b.equal(rO.get("promotionId"), rPromo.get("id")),
                b.equal(rO.get("auctionId"), rA.get("id")),
                b.equal(rS.get("id"), rA.get("shipperId")),
                b.equal(rP.get("id"), rA.get("productId")),
                b.equal(rC.get("id"), rP.get("customerId")),
                b.equal(rC.get("id"), customerId));

        q.multiselect(rP.get("productname"), rP.get("image"), rP.get("shipaddress"), rPromo.get("discount"), rA.get("price"),
                rS.get("firstname"), rS.get("lastname"),
                rO.get("orderdate"), rO.get("shipdate"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> listOrderOfShipper(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rPromo = q.from(Promotion.class);
        Root rA = q.from(Auction.class);
        Root rO = q.from(ShipOrder.class);
        Root rP = q.from(Product.class);
        Root rC = q.from(Customer.class);

        q.where(b.equal(rPromo.get("id"), rO.get("promotionId")),
                b.equal(rA.get("id"), rO.get("auctionId")),
                b.equal(rA.get("productId"), rP.get("id")),
                b.equal(rP.get("customerId"), rC.get("id")),
                b.equal(rA.get("shipperId"), shipperId));
        q.multiselect(rP.get("productname"), rP.get("image"), rP.get("shipaddress"),
                rC.get("firstname"), rC.get("lastname"), rC.get("phone"), rC.get("address"),
                rA.get("price"), rPromo.get("discount"),
                rO.get("shipdate"),rO.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void updateShipDate(int shiporderId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Update ShipOrder set shipdate=:date where id=:shiporderId");
        q.setParameter("date", new Date());
        q.setParameter("shiporderId", shiporderId);
        int r = q.executeUpdate();
    }

}
