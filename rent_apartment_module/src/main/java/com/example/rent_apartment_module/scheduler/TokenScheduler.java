package com.example.rent_apartment_module.scheduler;

import com.example.rent_apartment_module.dao.UserRentDaoImpl;
import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import com.example.rent_apartment_module.repository.UserRentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class TokenScheduler {

    private final UserRentRepository userRentRepository;
    private final UserRentDaoImpl userRentDao;

    @Scheduled(fixedDelay = 86_400_000)
    public void isActiveToken() {
        log.info("Проверка токена запущена " + LocalDateTime.now());
        List<UserRentEntityRent> tokenList = userRentDao.findUserRentEntityByQueryDSLIsNotNull();
        for (UserRentEntityRent user : tokenList) {
            LocalDateTime tokenDate = parseTokenValue(user.getToken());
            if (!checkTokenDate(tokenDate)) {
                log.info("Токен " + user.getToken() + " истёк и был удалён");
                user.setToken(null);
                userRentRepository.save(user);
            }
        }
        log.info("Проверка токена выполнена " + LocalDateTime.now());
    }

    private LocalDateTime parseTokenValue(String token) {
        int datePosition = token.indexOf("|") + 1;
        String dateStringFormat = token.substring(datePosition);
        return LocalDateTime.parse(dateStringFormat);
    }

    private Boolean checkTokenDate(LocalDateTime tokenDate) {
        return !LocalDateTime.now().isAfter(tokenDate);
    }
}
