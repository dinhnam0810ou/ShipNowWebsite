/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndn.pojos.Customer;
import com.ndn.pojos.Product;
import com.ndn.repository.ProductRepository;
import com.ndn.service.CustomerService;
import com.ndn.service.ProductService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {
        return this.productRepository.getProducts(params, page);
    }

    @Override
    public int countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public boolean addProduct(Product p) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Map result = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) result.get("secure_url");
            p.setImage(img);
            p.setCreatedDate(new Date());
            Customer cus = this.customerService.getCustomerByUserName(authentication.getName());
            p.setCustomerId(cus);
            return this.productRepository.addProduct(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> productNotAuction() {
        return this.productRepository.productNotAuction();
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public void updateActive(int productId) {
        this.productRepository.updateActive(productId);
    }
}
