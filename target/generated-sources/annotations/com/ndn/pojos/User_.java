package com.ndn.pojos;

import com.ndn.pojos.Customer;
import com.ndn.pojos.Shipper;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-08T20:51:43")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Date> date;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Shipper> shipperSet;
    public static volatile SetAttribute<User, Customer> customerSet;
    public static volatile SingularAttribute<User, Integer> active;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> username;

}