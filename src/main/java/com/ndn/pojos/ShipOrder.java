/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Entity
@Table(name = "ship_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShipOrder.findAll", query = "SELECT s FROM ShipOrder s"),
    @NamedQuery(name = "ShipOrder.findById", query = "SELECT s FROM ShipOrder s WHERE s.id = :id"),
    @NamedQuery(name = "ShipOrder.findByOrderdate", query = "SELECT s FROM ShipOrder s WHERE s.orderdate = :orderdate"),
    @NamedQuery(name = "ShipOrder.findByShipdate", query = "SELECT s FROM ShipOrder s WHERE s.shipdate = :shipdate")})
public class ShipOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Column(name = "shipdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipdate;
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    @ManyToOne
    private Auction auctionId;
    @Column(name = "discount")
    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public ShipOrder() {
    }

    public ShipOrder(Integer id) {
        this.id = id;
    }

    public ShipOrder(Integer id, Date orderdate) {
        this.id = id;
        this.orderdate = orderdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public Auction getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Auction auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipOrder)) {
            return false;
        }
        ShipOrder other = (ShipOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndn.pojos.ShipOrder[ id=" + id + " ]";
    }
    
}
