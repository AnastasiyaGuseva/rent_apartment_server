package com.example.rent_apartment_module.scheduler;

import com.example.rent_apartment_module.dao.RatingDao;
import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.example.rent_apartment_module.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@RequiredArgsConstructor
@EnableScheduling
public class RatingScheduler {
    private Logger log = LoggerFactory.getLogger(RatingScheduler.class);

    private final ApartmentRepository apartmentRepository;
    private final RatingDao ratingDao;

    @Scheduled(fixedDelay = 86_400_000)
    public void updateApartmentRating() {
        log.info("Запуск планировщика, обновление рейтинга " + LocalDateTime.now());
        List<ApartmentEntityRent> apartments = apartmentRepository.findAll();
        for (ApartmentEntityRent apartment : apartments) {
            Double avgRating = ratingDao.findRatingEntitiesByApartmentEntityByQueryDSL(apartment);
            apartment.setFoolRating(avgRating);
            apartmentRepository.save(apartment);
        }
        log.info("Обновление рейтинга закончено " + LocalDateTime.now());
    }
}
