package com.example.sales_apartment_module.configuration;

import com.example.sales_apartment_module.model.entity.EmailSenderSales;
import com.example.sales_apartment_module.repository.EmailSenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class EmailSenderConfig {

    private final EmailSenderRepository emailSenderRepository;

    @Bean
    public JavaMailSender getMailSender() {
        EmailSenderSales emailSender = emailSenderRepository.findById("EMAIL").get();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(emailSender.getHost());
        javaMailSender.setPassword(emailSender.getPassword());
        javaMailSender.setPort(emailSender.getPort());
        javaMailSender.setUsername(emailSender.getUsername());

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol", emailSender.getProtocol());
        properties.setProperty("mail.debug", "true");
        return javaMailSender;
    }
}
