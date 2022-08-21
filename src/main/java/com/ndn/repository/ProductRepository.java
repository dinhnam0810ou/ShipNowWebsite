/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface ProductRepository {

    List<Product> getProducts(Map<String, String> params, int page);

    int countProduct();

    boolean addProduct(Product p);

    List<Product> productNotAuction();
    Product getProductById(int productId);
}
