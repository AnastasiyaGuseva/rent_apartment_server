package com.example.sales_apartment_module.service;

import com.example.sales_apartment_module.model.entity.EmailSenderSales;
import com.example.sales_apartment_module.repository.EmailSenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    private final EmailSenderRepository emailSenderRepository;

    @Override
    public void sendEmail(String subject, String text, String sendTo) {
        EmailSenderSales emailSender = emailSenderRepository.findById("EMAIL").get();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailSender.getUsername());
        message.setSubject(subject);
        message.setText(text);
        message.setTo(sendTo);
        javaMailSender.send(message);
    }
}
