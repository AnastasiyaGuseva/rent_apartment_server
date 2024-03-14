package com.example.rent_apartment_module.exception;

public class ExceptionConstant {

    /**
     * Exception message constants
     */
    public final static String NOT_UNIQUE_NICKNAME = "Никнейм занят";
    public final static String REST_TEMPLATE_EXCEPTION = " Ошибка RestTemplateException";
    public final static String LOGGING_EXCEPTION = "Логин занят";
    public final static String UNAUTHORISED_EXCEPTION = "Пользователь не зарегистрирован";
    public final static String PASSWORD_EXCEPTION = "Неверный пароль";
    public final static String OVERDUE_TOKEN_EXCEPTION = "Токен не активен, войдите в систему или зарегистрируйтесь";

    /**
     * Exception code constants
     */

    public final static int NOT_UNIQUE_NICKNAME_CODE = 801;
    public final static int REST_TEMPLATE_EXCEPTION_CODE = 802;
    public final static int LOGGING_EXCEPTION_CODE = 803;
    public final static int UNAUTHORISED_EXCEPTION_CODE = 804;
    public final static int PASSWORD_EXCEPTION_CODE = 805;
    public final static int OVERDUE_TOKEN_EXCEPTION_CODE = 806;
}
