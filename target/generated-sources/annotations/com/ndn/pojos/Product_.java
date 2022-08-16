package com.ndn.pojos;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-16T16:37:57")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SetAttribute<Product, Auction> auctionSet;
    public static volatile SingularAttribute<Product, Date> createdDate;
    public static volatile SingularAttribute<Product, String> shipaddress;
    public static volatile SingularAttribute<Product, Customer> customerId;
    public static volatile SingularAttribute<Product, String> productname;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Boolean> active;
    public static volatile SingularAttribute<Product, Double> weight;
    public static volatile SingularAttribute<Product, Integer> id;

}