package com.ndn.pojos;

import com.ndn.pojos.Comment;
import com.ndn.pojos.Product;
import com.ndn.pojos.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-14T23:00:02")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SetAttribute<Customer, Comment> commentSet;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, User> userId;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> lastname;
    public static volatile SetAttribute<Customer, Product> productSet;

}