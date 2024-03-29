package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.UserRentEntityRent;

import java.util.List;

public interface UserRentDao {
    UserRentEntityRent findUserByNickName(String nickName);

    UserRentEntityRent findUserByNickNameQueryDSL(String nickName);

    UserRentEntityRent findUserByLogin(String login);

    UserRentEntityRent findUserByLoginQueryDSL(String login);

    List<UserRentEntityRent> findUserRentEntityByTokenIsNotNull();

    List<UserRentEntityRent> findUserRentEntityByQueryDSLIsNotNull();

    UserRentEntityRent findByToken(String token);

    UserRentEntityRent findByTokenQueryDSL(String token);
}
