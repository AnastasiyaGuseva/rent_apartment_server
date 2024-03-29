package com.example.sales_apartment_module.controller;

import com.example.sales_apartment_module.service.CheckTokenService;
import com.example.sales_apartment_module.service.DiscountService;
import com.example.sales_apartment_module.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.sales_apartment_module.constant.SalesApartmentConstant.DISCOUNT_URL;
import static com.example.sales_apartment_module.constant.SalesApartmentConstant.REPORT_MESSAGE;

@RestController
@RequiredArgsConstructor
public class SalesController {

    private final DiscountService discountService;

    private final CheckTokenService checkTokenService;

    private final ReportService reportService;

    @GetMapping(DISCOUNT_URL)
    public String findDiscount(@PathVariable Long id, @RequestParam String key) {
        checkTokenService.checkToken(key);
        return discountService.optimalDiscount(id);
    }

    @GetMapping(REPORT_MESSAGE)
    public void getReport() {
        reportService.report();
    }
}

