package com.example.sales_apartment_module.controller;

import com.example.sales_apartment_module.service.CheckTokenService;
import com.example.sales_apartment_module.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.sales_apartment_module.constant.SalesApartmentConstant.DISCOUNT_URL;

@RestController
@RequiredArgsConstructor
public class SalesController {

    private final DiscountService discountService;

    private final CheckTokenService checkTokenService;

    @GetMapping(DISCOUNT_URL)
    private String findDiscount(@PathVariable Long id, @RequestParam String key) {
        checkTokenService.checkToken(key);
        return discountService.optimalDiscount(id);
    }
}

