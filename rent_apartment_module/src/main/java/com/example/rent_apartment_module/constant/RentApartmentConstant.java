package com.example.rent_apartment_module.constant;

public class RentApartmentConstant {

    /**
     * Path constant
     */
    public final static String BASE_AUTH_URL = "/api/v1";
    public final static String BASE_URL = "/api/v1/apartment";
    public final static String REG = BASE_AUTH_URL + "/registration";
    public final static String AUTH = BASE_AUTH_URL + "/authorisation";
    public final static String REG_APARTMENT = BASE_URL + "/add_apartment";
    public final static String GET_RATING = BASE_URL + "/get_rating/{id}";
    public final static String APARTMENT_FOR_BOOKING = BASE_URL + "/show_apartment/{id}";
    public final static String APARTMENTS_BY_GEO = BASE_URL + "/apartment_by_location";
    public final static String BOOKING_APARTMENT = BASE_URL + "/booking/{apartmentId}";

    /**
     * Message constant
     */
    public final static String SAVE_NEW_APARTMENT_MESSAGE = "Апартаменты сохранены";
    public final static String FIND_APARTMENT = "Информация по апартаментам отсутствует";
    public final static String IS_FREE = "Апартаменты доступны для бронирования";
    public final static String UNSAFE_PASSWORD_MESSAGE = "Пароль должен состоять не менее чем из 8 символов и должен " +
            "быть комбинацией заглавных и строчных букв, цифр и специальных символов.";
    public final static String MESSAGE_BOOKING = "Бронирование прошло успешно";

    public final static String SUCCESSFUL_REGISTRATION = "Успешная регистрация";

    /**
     * Integration constants
     */
    public final static String GEO = "GEO";
    public final static String PRODUCT = "PRODUCT";


}
