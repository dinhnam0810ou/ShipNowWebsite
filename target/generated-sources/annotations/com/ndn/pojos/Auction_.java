package com.ndn.pojos;

import com.ndn.pojos.Product;
import com.ndn.pojos.ShipOrder;
import com.ndn.pojos.Shipper;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-14T23:00:02")
@StaticMetamodel(Auction.class)
public class Auction_ { 

    public static volatile SingularAttribute<Auction, Date> date;
    public static volatile SetAttribute<Auction, ShipOrder> shipOrderSet;
    public static volatile SingularAttribute<Auction, Shipper> shipperId;
    public static volatile SingularAttribute<Auction, Product> productId;
    public static volatile SingularAttribute<Auction, Double> price;
    public static volatile SingularAttribute<Auction, Integer> id;

}