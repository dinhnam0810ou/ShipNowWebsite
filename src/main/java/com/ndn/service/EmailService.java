/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.service;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface EmailService {
    void sendSimpleMessage(String to,String subject, String text);
    void userSendMail(String from,String subject, String text);
}
