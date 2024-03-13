package com.example.sales_apartment_module.service;

public interface EmailSenderService {
     void sendEmail(String subject, String text, String sendTo);
}
