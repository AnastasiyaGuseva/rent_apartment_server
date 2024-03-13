package com.example.rent_apartment_module.repository;

import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRentRepository extends JpaRepository<UserRentEntityRent, Integer> {
    UserRentEntityRent findUserRentEntityByNickNameAndLogin(String nickName, String login);

    @Query(nativeQuery = true, value = "SELECT * FROM user_info WHERE nick_name = :nickName")
    UserRentEntityRent findUserByNickName(String nickName);//todo: Native SQL query

    @Query(value = "SELECT u FROM UserRentEntityRent u WHERE u.nickName = :nickName")
    UserRentEntityRent findUserByNickNameJPQL(String nickName);//todo: JPQL query


    @Query(value = "SELECT u FROM UserRentEntityRent u WHERE u.login = :login")
    UserRentEntityRent findUserByLoginJPQL(String login);//todo: JPQL query

    List<UserRentEntityRent> findUserRentEntityByTokenIsNotNull();

    UserRentEntityRent findByToken(String token);


}
