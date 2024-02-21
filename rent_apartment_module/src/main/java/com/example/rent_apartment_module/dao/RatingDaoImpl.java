package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.rent_apartment_module.model.entity.QRatingEntityRent.ratingEntityRent;

@Repository
@AllArgsConstructor
public class RatingDaoImpl implements RatingDao {

    private final EntityManager entityManager;

    public List<RatingEntityRent> findRatingEntitiesByApartmentEntity(ApartmentEntityRent apartmentEntityRent) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();// Интерфейс, который предоставляет вызовы для запросов
        CriteriaQuery<RatingEntityRent> query = builder.createQuery(RatingEntityRent.class); // Создание запроса, необходимо указать тип возвращаемого элемента
        Root<RatingEntityRent> entityRoot = query.from(RatingEntityRent.class); // Корневой элемент - точка начала запроса
        // Связываем RatingEntityRent с ApartmentEntityRent по полю apartmentEntityRent
        Join<RatingEntityRent, ApartmentEntityRent> apartmentEntityJoin = entityRoot.join("apartmentEntityRent");
        // Создаем предикат для фильтрации результатов по apartmentEntityRent
        Predicate predicate = builder.equal(apartmentEntityJoin, apartmentEntityRent);
        // Применяем предикат к CriteriaQuery
        query.where(predicate);
        List<RatingEntityRent> ratingEntityRentList = entityManager.createQuery(query).getResultList();
        return ratingEntityRentList;
    }

    public Double findRatingEntitiesByApartmentEntityByQueryDSL(ApartmentEntityRent apartmentEntityRent) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Double ratings = queryFactory.select(ratingEntityRent.overallRating.avg())
                .from(ratingEntityRent)
                .join(QApartmentEntityRent.apartmentEntityRent.apartmentRating)
                .where(ratingEntityRent.apartmentEntityRent.eq(apartmentEntityRent))
                .fetchOne();
        return ratings;
    }
}