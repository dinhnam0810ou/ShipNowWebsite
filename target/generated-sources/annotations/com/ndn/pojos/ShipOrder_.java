package com.ndn.pojos;

import com.ndn.pojos.Auction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-15T11:16:57")
@StaticMetamodel(ShipOrder.class)
public class ShipOrder_ { 

    public static volatile SingularAttribute<ShipOrder, Auction> auctionId;
    public static volatile SingularAttribute<ShipOrder, Double> discount;
    public static volatile SingularAttribute<ShipOrder, Integer> id;
    public static volatile SingularAttribute<ShipOrder, Date> orderdate;
    public static volatile SingularAttribute<ShipOrder, Date> shipdate;

}