package com.ndn.pojos;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Promotion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-02T22:43:36")
@StaticMetamodel(ShipOrder.class)
public class ShipOrder_ { 

    public static volatile SingularAttribute<ShipOrder, Auction> auctionId;
    public static volatile SingularAttribute<ShipOrder, Integer> pay;
    public static volatile SingularAttribute<ShipOrder, Integer> id;
    public static volatile SingularAttribute<ShipOrder, Date> orderdate;
    public static volatile SingularAttribute<ShipOrder, Promotion> promotionId;
    public static volatile SingularAttribute<ShipOrder, Date> shipdate;

}