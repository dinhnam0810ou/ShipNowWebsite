/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository.impl;

import com.ndn.pojos.Comment;
import com.ndn.pojos.Customer;
import com.ndn.pojos.User;
import com.ndn.repository.CommentRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
@Transactional
@PropertySource("classpath:messages.properties")
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Override
    public List<Object[]> getCommentByShipperId(int shipperId,int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root = q.from(Comment.class);
        Root rootC = q.from(Customer.class);
        Root rootU = q.from(User.class);
        
        
        q = q.where(b.equal(root.get("shipperId"), shipperId),
                b.equal(rootU.get("id"), rootC.get("userId")),
                b.equal(rootC.get("id"), root.get("customerId")));
        q.multiselect(rootU.get("username"),rootC.get("avatar"),root.get("content"),root.get("date"),root.get("rating"));
        q = q.orderBy(b.desc(root.get("id")));
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
    public int countComment(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Comment Where shipperId.id=:id");
        q.setParameter("id", shipperId);
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Comment addComment(Comment c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
           session.save(c);
           return c;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

   
   
}
