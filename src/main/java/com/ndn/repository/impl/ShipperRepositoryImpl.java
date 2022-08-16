/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Promotion;
import com.ndn.pojos.ShipOrder;
import com.ndn.pojos.Shipper;
import com.ndn.repository.ShipperRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class ShipperRepositoryImpl implements ShipperRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Shipper> getShippers(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Shipper> q = b.createQuery(Shipper.class);
        Root root = q.from(Shipper.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {

                Predicate p = b.like(b.concat(root.get("firstname"), root.get("lastname")).as(String.class),
                        String.format("%%%s%%", kw));
                // Predicate p = b.or(b.like(root.get("firstname").as(String.class),String.format("%%%s%%", kw)),b.like(root.get("lastname").as(String.class),String.format("%%%s%%", kw)));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }

        q.orderBy(b.desc(root.get("id")), b.desc(root.get("lastname")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Shipper");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addShipper(Shipper shipper) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(shipper);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteShipper(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Shipper s = session.get(Shipper.class, id);
            session.delete(s);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Shipper getShipperById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Shipper.class, id);
    }

    @Override
    public List<Object[]> countOrderByShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(ShipOrder.class);
        Root rA = q.from(Auction.class);
        Root rS = q.from(Shipper.class);

        q.where(b.equal(rO.get("auctionId"), rA.get("id")),
                b.equal(rS.get("id"), rA.get("shipperId")));

        q.multiselect(rS.get("id"), rS.get("firstname"), rS.get("lastname"), b.count(rO.get("id")));
        q.groupBy(rA.get("shipperId"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> revenue(int quarter, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(ShipOrder.class);
        Root rA = q.from(Auction.class);
        Root rS = q.from(Shipper.class);
        Root rP = q.from(Promotion.class);
        
        q.where(b.equal(rO.get("auctionId"), rA.get("id")),
                b.equal(rS.get("id"), rA.get("shipperId")),
                b.equal(b.function("QUARTER", Integer.class, rO.get("orderdate")), quarter),
                b.equal(b.function("YEAR", Integer.class, rO.get("orderdate")), year),
                b.equal(rO.get("promotionId"), rP.get("id")));

        q.multiselect(rS.get("id"), rS.get("firstname"), rS.get("lastname"), b.sum(b.prod(rA.get("price"), rP.get("discount"))));
        q.groupBy(rA.get("shipperId"));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
