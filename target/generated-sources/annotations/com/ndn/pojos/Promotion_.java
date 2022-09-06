package com.ndn.pojos;

import com.ndn.pojos.ShipOrder;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-06T09:19:44")
@StaticMetamodel(Promotion.class)
public class Promotion_ { 

    public static volatile SetAttribute<Promotion, ShipOrder> shipOrderSet;
    public static volatile SingularAttribute<Promotion, Integer> quantity;
    public static volatile SingularAttribute<Promotion, String> code;
    public static volatile SingularAttribute<Promotion, Double> discount;
    public static volatile SingularAttribute<Promotion, Date> createdate;
    public static volatile SingularAttribute<Promotion, String> description;
    public static volatile SingularAttribute<Promotion, Integer> id;
    public static volatile SingularAttribute<Promotion, Date> expirationdate;

}