package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.dao.UserRentDao;
import com.example.rent_apartment_module.exception.*;
import com.example.rent_apartment_module.mapper.RentApartmentMapper;
import com.example.rent_apartment_module.model.dto.AuthorisationUserInfoDto;
import com.example.rent_apartment_module.model.dto.RegistrationUserInfoDto;
import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import com.example.rent_apartment_module.repository.UserRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.rent_apartment_module.constant.RentApartmentConstant.SUCCESSFUL_REGISTRATION;
import static com.example.rent_apartment_module.exception.ExceptionConstant.*;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserRentServiceImpl implements UserRentService {

    private final UserRentRepository userRentRepository;

    private final UserRentDao userRentDao;

    private final RentApartmentMapper mapper;

    @Override
    public String saveUserRentEntity(RegistrationUserInfoDto userInfoDto) {

        UserRentEntityRent userByNickName = userRentDao.findUserByNickNameQueryDSL(userInfoDto.getNickName());
        if (!isNull(userByNickName)) {
            throw new UserAuthException(NOT_UNIQUE_NICKNAME, NOT_UNIQUE_NICKNAME_CODE);
        }
        UserRentEntityRent userByLogin = userRentDao.findUserByLoginQueryDSL(userInfoDto.getLogin());
        if (!isNull(userByLogin)) {
            throw new IncorrectLoginException(LOGGING_EXCEPTION, LOGGING_EXCEPTION_CODE);
        }

        userRentRepository.save(mapper.toUserRentEntity(userInfoDto));

        return SUCCESSFUL_REGISTRATION;
    }

    @Override
    public String authUserRentEntity(AuthorisationUserInfoDto userInfoDto) {
        UserRentEntityRent user = userRentDao.findUserByLoginQueryDSL(userInfoDto.getLogin());

        if (isNull(user)) {
            throw new UserUnauthorisedException(UNAUTHORISED_EXCEPTION, UNAUTHORISED_EXCEPTION_CODE);
        }
        if (!user.getPassword().equals(userInfoDto.getPassword())) {
            throw new IncorrectPasswordException(PASSWORD_EXCEPTION, PASSWORD_EXCEPTION_CODE);
        }
        String token = uniqToken();
        user.setToken(token);
        userRentRepository.save(user);
        return token;
    }

    @Override
    public Boolean findByToken(String token) {
        if (isNull(userRentDao.findByTokenQueryDSL(token))) {
            throw new OverdueTokenException(OVERDUE_TOKEN_EXCEPTION, OVERDUE_TOKEN_EXCEPTION_CODE);
        }
        return true;
    }

    private String uniqToken() {
        String uniqueToken = UUID.randomUUID().toString();
        return uniqueToken + "|" + LocalDateTime.now().plusDays(1L);
    }

}
