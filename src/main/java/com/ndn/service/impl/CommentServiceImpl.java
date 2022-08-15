/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.ndn.pojos.Comment;
import com.ndn.pojos.Customer;
import com.ndn.pojos.Shipper;
import com.ndn.repository.CommentRepository;
import com.ndn.repository.CustomerRepository;
import com.ndn.repository.ShipperRepository;
import com.ndn.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Comment> getCommentByShipperId(int shipperId, int page) {
        return this.commentRepository.getCommentByShipperId(shipperId, page);
    }

    @Override
    public int countComment(int shipperId) {
        return this.commentRepository.countComment(shipperId);
    }

    @Override
    public Comment addComment(String content, int shipperId) {
        Shipper s = this.shipperRepository.getShipperById(shipperId);
        Customer c = this.customerRepository.getCustomerById(2);
        
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setDate(new Date());
        comment.setCustomerId(c);
        comment.setShipperId(s);
        
        return this.commentRepository.addComment(comment);
    }

  
}