package com.example.sales_apartment_module.service;

import com.example.sales_apartment_module.model.entity.BookingEntitySales;
import com.example.sales_apartment_module.repository.BookingEntityRepository;
import com.example.sales_apartment_module.repository.ProductDiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static com.example.sales_apartment_module.constant.SalesApartmentConstant.*;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final BookingEntityRepository bookingRepository;

    private final ProductDiscountRepository discountRepository;

    private final EmailSenderService emailSenderService;

    //метод получение бронирования по id
    public BookingEntitySales bookingByID(Long id) {
      return   bookingRepository.findByIdJPQL(id);
        //return bookingRepository.findById(id).get();//LazyInitialization
    }

    //метод проверки и получения скидки по дате рождения
    private Integer discountByBirthDate(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        Month month = bookingEntitySales.getUserId().getBirthDate().getMonth();
        Integer dayOfMonth = bookingEntitySales.getUserId().getBirthDate().getDayOfMonth();
        Month bookingMonth = bookingEntitySales.getStartDate().getMonth();
        Integer bookingDayOfMonth = bookingEntitySales.getStartDate().getDayOfMonth();
        if (bookingMonth.equals(month) && bookingDayOfMonth.equals(dayOfMonth) &&
                discountRepository.findById(6L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(6L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод проверки и получения скидки по городу проживания
    private Integer discountByCityOfLiving(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        if (!Objects.equals(bookingEntitySales.getUserId().getCityOfLiving(),
                bookingEntitySales.getApartmentId().getAddress().getCity()) &&
                discountRepository.findById(7L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(7L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод проверки и получения скидки на определённые сезоны
    private Integer discountBySeason(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        Month bookingMonth = bookingEntitySales.getStartDate().getMonth();
        if (bookingMonth.equals(Month.FEBRUARY) || bookingMonth.equals(Month.NOVEMBER)
                || bookingMonth.equals(Month.MARCH) &&
                discountRepository.findById(3L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(3L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод проверки и получения скидки по кол-ву бронирования
    private Integer discountByBookingAmount(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        if (bookingEntitySales.getUserId().getBookingCount() >= 3 &&
                discountRepository.findById(5L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(5L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод проверки и получения скидки на первое бронирование
    private Integer discountByFirstBooking(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        if (bookingEntitySales.getUserId().getBookingCount() == 0 &&
                discountRepository.findById(1L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(1L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод проверки группового бронирования
    private Integer discountByPeopleAmount(Long id) {
        BookingEntitySales bookingEntitySales =  bookingRepository.findByIdJPQL(id);//LazyInitialization
        if (bookingEntitySales.getPeopleAmount() >= 3 &&
                discountRepository.findById(4L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(4L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод проверки скидки по длительности бронирования
    private Integer discountByDuration(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        if (bookingEntitySales.getEndDate().isAfter(bookingEntitySales.getStartDate().plusWeeks(2)) &&
                discountRepository.findById(2L).get().getIsDiscountActive().equals(true)) {
            Integer discountAmount = discountRepository.findById(2L).get().getDiscountAmount();
            return bookingEntitySales.getApartmentId().getPrice() - discountAmount;
        }
        return bookingEntitySales.getApartmentId().getPrice();
    }

    //метод применения разных скидок и вычисления наиболее выгодной
    //todo: Формирование и вывод сообщения о проведённом бронировании, цене, адресе и применённой скидке
    public String optimalDiscount(Long id) {
        Integer individualCost = List.of(
                discountByPeopleAmount(id),
                discountByBirthDate(id),
                discountByDuration(id),
                discountByCityOfLiving(id),
                discountBySeason(id),
                discountByBookingAmount(id),
                discountByFirstBooking(id)
        ).stream().min(Comparator.comparingInt(Integer::intValue)).get();
        BookingEntitySales bookingEntitySales = bookingByID(id);
        bookingEntitySales.setFinalCost(individualCost);
        bookingRepository.save(bookingEntitySales);
        sendEmail(id);
        return MESSAGE_MAIL;
    }

    private void sendEmail(Long id) {
        BookingEntitySales bookingEntitySales = bookingByID(id);
        String city = bookingEntitySales.getApartmentId().getAddress().getCity();
        String street = bookingEntitySales.getApartmentId().getAddress().getStreet();
        String homeNumber = bookingEntitySales.getApartmentId().getAddress().getHomeNumber();
        String message = String.format(MESSAGE, city, street, homeNumber,
                bookingEntitySales.getFinalCost());
        emailSenderService.sendEmail(MESSAGE_BOOKING, message, bookingEntitySales.getUserId().getLogin());
    }
}
