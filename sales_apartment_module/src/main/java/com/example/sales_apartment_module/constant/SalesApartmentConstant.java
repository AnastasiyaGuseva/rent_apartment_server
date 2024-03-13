package com.example.sales_apartment_module.constant;

public class SalesApartmentConstant {

    /**
     * Path constant
     */
    public final static String BASE_URL = "/api/v1/sales";
    public final static String DISCOUNT_URL = BASE_URL + "/discount/{id}";

    /**
     * Message constant
     */
    public final static String MESSAGE = "Добрый день, ваше бронирование по адресу г. %s, ул. %s, %s.  было подтверждено.  \n" +
            "С учётом применённой скидки стоимость бронирования будет составлять %d. \n" +
            "Желаем вам хорошего отдыха!";

    public final static String MESSAGE_BOOKING = "Бронирование прошло успешно";
    public final static String MESSAGE_MAIL = "Письмо было успешно отправлено";

}
