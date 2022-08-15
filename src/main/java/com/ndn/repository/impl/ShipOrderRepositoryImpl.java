/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Product;
import com.ndn.pojos.ShipOrder;
import com.ndn.pojos.Shipper;
import com.ndn.repository.ShipOrderRepository;
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
        q.multiselect(rO.get("id"), rS.get("firstname"), rS.get("lastname"), rP.get("productname"),rO.get("orderdate"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
