package com.example.sales_apartment_module.service;

import com.example.sales_apartment_module.entity.BookingEntitySales;
import com.example.sales_apartment_module.repository.BookingEntityRepository;
import com.example.sales_apartment_module.repository.ProductDiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final BookingEntityRepository bookingRepository;

    private final ProductDiscountRepository discountRepository;

    //метод получение бронирования по id
    private BookingEntitySales bookingByID(Long id){
        return bookingRepository.findById(id).get();
    }

    //метод проверки и получения скидки по дате рождения
    //:todo Логика для проверки
    private Integer discountByBirthDate(BookingEntitySales bookingEntitySales){
    return  bookingEntitySales.getFinalCost();
    }
    //метод проверки скидки по длительности бронирования
    //:todo Проверка скидки на активность
    private Integer discountByDuration(BookingEntitySales bookingEntitySales){

        if(bookingEntitySales.getEndDate().isAfter(bookingEntitySales.getStartDate().plusWeeks(2))){
            Integer discountAmount = discountRepository.findById(1L).get().getDiscountAmount();
            return  bookingEntitySales.getFinalCost()- discountAmount;
        }
        return  bookingEntitySales.getFinalCost();
    }

    //метод применения разных скидок и вычисления наиболее выгодной
    //todo: Формирование и вывод сообщения о проведённом бронировании, цене, адресе и применённой скидке
     public void optimalDiscount(BookingEntitySales bookingEntitySales){

        Integer individualCost = List.of(
                discountByBirthDate(bookingEntitySales),
                discountByDuration(bookingEntitySales)
        ).stream().min(Comparator.comparingInt(Integer::intValue)).get();

        bookingEntitySales.setFinalCost(individualCost);
        bookingRepository.save(bookingEntitySales);
    }

}
