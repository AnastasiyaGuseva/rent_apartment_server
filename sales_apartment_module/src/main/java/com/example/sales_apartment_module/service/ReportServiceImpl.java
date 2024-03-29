package com.example.sales_apartment_module.service;

import com.example.sales_apartment_module.repository.BookingEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final BookingEntityRepository bookingEntityRepository;
    private final ApachePoiService apachePoiService;


    @Override
    public void report() {
        apachePoiService.getReport(bookingEntityRepository.findAll());
    }
}
