package com.example.sales_apartment_module.controller;

import com.example.sales_apartment_module.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.example.sales_apartment_module.constant.SalesApartmentConstant.DISCOUNT_URL;

@RestController
@RequiredArgsConstructor
public class SalesController {

    private final DiscountService discountService;
    @GetMapping(DISCOUNT_URL)
    private String findDiscount(@PathVariable Long id){
        return discountService.optimalDiscount(id);
    }
}

