/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.Promotion;
import java.util.List;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface PromotionRepository {
    List<Promotion> getPromotions();
    boolean addPromotion(Promotion promotion);
    Promotion getPromotionByCode(String code);
    Promotion getPromotionById(int promotionId);
    void setPromotionDefault(int shiporderId);
}
