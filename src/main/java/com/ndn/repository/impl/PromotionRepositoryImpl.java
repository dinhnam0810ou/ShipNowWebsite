/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Promotion;
import com.ndn.repository.PromotionRepository;
import java.util.List;
import javax.persistence.Query;
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
public class PromotionRepositoryImpl implements PromotionRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Promotion> getPromotions() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Promotion");
        return q.getResultList();
    }

    @Override
    public boolean addPromotion(Promotion promotion) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(promotion);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
