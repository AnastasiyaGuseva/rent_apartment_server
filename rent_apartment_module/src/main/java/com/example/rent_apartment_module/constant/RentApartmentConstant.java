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
    public final static String GET_RATING = BASE_URL + "/get_rating";
    public final static String BOOKING = BASE_URL + "/booking";
    public final static String APARTMENTS_BY_GEO = BASE_URL + "/apartment_by_location";


    /**
     * Message constant
     */
    public final static String SAVE_NEW_APARTMENT_MESSAGE = "Апартаменты сохранены";
    public final static String FIND_APARTMENT = "Информация по апартаментам отсутствует";
    public final static String IS_FREE = "Апартаменты доступны для бронирования";

    /**
     * Integration constants
     */
    public final static String GEO = "GEO";

}
