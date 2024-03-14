package com.example.sales_apartment_module.kafka;

import com.example.sales_apartment_module.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.kafka.support.KafkaHeaders.GROUP_ID;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final List<String> messages = new ArrayList<>();
    private final String TOPIC = "booking_id";

    private final DiscountService discountService;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    @Transactional
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
            for (String mes : messages) {
                discountService.optimalDiscount(Long.valueOf(mes));
            }
        }
    }
}
