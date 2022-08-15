package com.ndn.pojos;

import com.ndn.pojos.Auction;
import com.ndn.pojos.Comment;
import com.ndn.pojos.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-14T23:00:02")
@StaticMetamodel(Shipper.class)
public class Shipper_ { 

    public static volatile SetAttribute<Shipper, Auction> auctionSet;
    public static volatile SingularAttribute<Shipper, String> firstname;
    public static volatile SingularAttribute<Shipper, String> identification;
    public static volatile SetAttribute<Shipper, Comment> commentSet;
    public static volatile SingularAttribute<Shipper, String> phone;
    public static volatile SingularAttribute<Shipper, Boolean> active;
    public static volatile SingularAttribute<Shipper, String> avatar;
    public static volatile SingularAttribute<Shipper, Integer> id;
    public static volatile SingularAttribute<Shipper, User> userId;
    public static volatile SingularAttribute<Shipper, String> email;
    public static volatile SingularAttribute<Shipper, String> lastname;

}