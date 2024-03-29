package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.dao.ApartmentDao;
import com.example.rent_apartment_module.dao.RatingDao;
import com.example.rent_apartment_module.exception.RestTemplateException;
import com.example.rent_apartment_module.logger.FunctionByLogger;
import com.example.rent_apartment_module.mapper.RentApartmentMapper;
import com.example.rent_apartment_module.mapper.RentMapper;
import com.example.rent_apartment_module.model.dto.ApartmentInfoDto;
import com.example.rent_apartment_module.model.dto.BookingInfoDto;
import com.example.rent_apartment_module.model.dto.BookingResponseDto;
import com.example.rent_apartment_module.model.dto.LocationInfoDto;
import com.example.rent_apartment_module.model.dto.geoDto.OpenCageData;
import com.example.rent_apartment_module.model.dto.geoDto.Result;
import com.example.rent_apartment_module.model.entity.AddressEntityRent;
import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.example.rent_apartment_module.model.entity.BookingEntityRent;
import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import com.example.rent_apartment_module.repository.AddressRepository;
import com.example.rent_apartment_module.repository.ApartmentRepository;
import com.example.rent_apartment_module.repository.BookingRepository;
import com.example.rent_apartment_module.repository.UserRentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.rent_apartment_module.constant.RentApartmentConstant.*;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    private Logger log = LoggerFactory.getLogger(ApartmentServiceImpl.class);

    private final ApartmentRepository apartmentRepository;

    private final AddressRepository addressRepository;

    private final RentApartmentMapper mapper;

    private final ApartmentDao apartmentDao;

    private final RatingDao ratingDao;

    private final RentMapper rentMapper;

    private final IntegrationService integrationService;

    private final BookingRepository bookingRepository;

    private final UserRentRepository userRepository;

    private final FunctionByLogger functionLog;

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public String saveApartmentEntity(ApartmentInfoDto apartmentInfoDto) {
        log.info("ApartmentServiceImpl: saveApartmentEntity()");
        log.info("saveApartmentEntity() MAPPING apartmentInfoDto AND SAVE APARTMENT");
        ApartmentEntityRent apartment = mapper.toApartmentEntity(apartmentInfoDto);
        apartmentRepository.save(apartment);
        log.info("saveApartmentEntity() MAPPING AND SAVE ADDRESS");
        AddressEntityRent address = mapper.toAddressEntity(apartmentInfoDto);
        address.setApartmentEntityRent(apartment);
        addressRepository.save(address);
        return SAVE_NEW_APARTMENT_MESSAGE;
    }

    @Override
    public Double getAverageRating(Long id) {
        ApartmentEntityRent apartmentEntityRent = apartmentRepository.findById(id).get();
        return ratingDao.findRatingEntitiesByApartmentEntityByQueryDSL(apartmentEntityRent);
    }

    @Override
    public BookingResponseDto showApartment(Long id) {
        ApartmentEntityRent apartment = apartmentDao.findApartmentByQueryDsl(id);
        return new BookingResponseDto(IS_FREE, rentMapper.toApartmentDto(apartment, apartment.getAddress()));
    }

    @Override
    public List<ApartmentInfoDto> apartmentByLocation(LocationInfoDto infoDto) {
        log.info("ApartmentServiceImpl: apartmentByLocation() ");
        log.info("apartmentByLocation() -> https://api.opencagedata.com/geocode/v1");
        OpenCageData locationInfo = integrationService.getInfoByLocation(infoDto);
        log.info("apartmentByLocation() <- https://api.opencagedata.com/geocode/v1");
        String city = getCityName(locationInfo.getResults());
        List<ApartmentEntityRent> apartments = apartmentDao.findApartmentByQueryDsl(city);

        return rentMapper.toApartmentInfoListDto(apartments);

    }

    @Override
    public String bookingApartment(BookingInfoDto bookingInfoDto, Long apartmentId, String token) {
        log.info("ApartmentServiceImpl: bookingApartment() : " + functionLog.getUserLogin(token));
        BookingEntityRent bookingInfoEntity = mapper.toBookingInfoEntity(bookingInfoDto);
        UserRentEntityRent userRentEntityRent = userRepository.findByToken(token);
        ApartmentEntityRent apartmentEntityRent = apartmentRepository.findById(apartmentId).get();
        // todo в отдельный метод
        bookingInfoEntity.setUserId(userRentEntityRent);
        bookingInfoEntity.setApartmentId(apartmentEntityRent);
        BookingEntityRent saved = bookingRepository.save(bookingInfoEntity);
        //в отдельный метод
        try {
            log.info("bookingApartment() -> http://localhost:9096/api/v1/sales/discount");
            integrationService.getInfoByBookingId(apartmentId);
            log.info("bookingApartment() <- http://localhost:9096/api/v1/sales/discount");
        } catch (RestTemplateException e) {
            log.error("bookingApartment() -> http://localhost:9096/api/v1/sales/discount : ERROR :" + e.getMessage());
            kafkaTemplate.send("booking_id", String.valueOf(saved.getId()));
        }
        return MESSAGE_BOOKING;
    }

    private String getCityName(List<Result> results) {
        return results.stream()
                .map(parameter -> {
                    String cityValue = parameter.getComponents().getCity();
                    return Objects.isNull(cityValue) ? parameter.getComponents().getTown() : cityValue;
                })
                .collect(Collectors.joining());
    }
}
