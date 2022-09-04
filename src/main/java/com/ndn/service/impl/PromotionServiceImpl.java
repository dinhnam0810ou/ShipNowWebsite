/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service.impl;

import com.ndn.pojos.Promotion;
import com.ndn.repository.PromotionRepository;
import com.ndn.service.PromotionService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getPromotions() {
        return this.promotionRepository.getPromotions();
    }

    @Override
    public boolean addPromotion(Promotion promotion) {
        promotion.setCreatedate(new Date());
        return this.promotionRepository.addPromotion(promotion);
    }

    @Override
    public Promotion getPromotionByCode(String code) {
        return this.promotionRepository.getPromotionByCode(code);
    }

    @Override
    public Promotion getPromotionById(int promotionId) {
        return this.promotionRepository.getPromotionById(promotionId);
    }

    @Override
    public void setPromotionDefault(int shiporderId) {
        this.promotionRepository.setPromotionDefault(shiporderId);
    }

}
