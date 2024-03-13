package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.dao.UserRentDao;
import com.example.rent_apartment_module.exception.UserAuthException;
import com.example.rent_apartment_module.mapper.RentApartmentMapper;
import com.example.rent_apartment_module.model.dto.AuthorisationUserInfoDto;
import com.example.rent_apartment_module.model.dto.RegistrationUserInfoDto;
import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import com.example.rent_apartment_module.repository.UserRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.rent_apartment_module.exception.ExceptionConstant.NOT_UNIQUE_NICKNAME;
import static com.example.rent_apartment_module.exception.ExceptionConstant.NOT_UNIQUE_NICKNAME_CODE;
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
            throw new UserAuthException(NOT_UNIQUE_NICKNAME,NOT_UNIQUE_NICKNAME_CODE);
        }
        UserRentEntityRent userByLogin = userRentDao.findUserByLoginQueryDSL(userInfoDto.getLogin());
        if (!isNull(userByLogin)) {
            throw new RuntimeException("Логин занят");
        }

        userRentRepository.save(mapper.toUserRentEntity(userInfoDto));

        return "Успешная регистрация";
    }

    @Override
    public String authUserRentEntity(AuthorisationUserInfoDto userInfoDto) {
        UserRentEntityRent user = userRentDao.findUserByLoginQueryDSL(userInfoDto.getLogin());

        if (isNull(user)) {
            throw new RuntimeException("Пользователь не зарегистрирован");
        }
        if (!user.getPassword().equals(userInfoDto.getPassword())) {
            throw new RuntimeException("Неверный пароль");
        }
        String token = uniqToken();
        user.setToken(token);
        userRentRepository.save(user);
        return token;
    }

    @Override
    public Boolean findByToken(String token) {
        if (isNull(userRentDao.findByTokenQueryDSL(token))) {
            throw new RuntimeException("Токен не активен, войдите в систему или зарегистрируйтесь");
        }
        return true;
    }


    private String uniqToken() {
        String uniqueToken = UUID.randomUUID().toString();
        return uniqueToken + "|" + LocalDateTime.now().plusDays(1L);
    }

}
