package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.example.rent_apartment_module.model.entity.QApartmentEntityRent;
import com.example.rent_apartment_module.model.entity.RatingEntityRent;
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RatingEntityRent> query = builder.createQuery(RatingEntityRent.class);
        Root<RatingEntityRent> entityRoot = query.from(RatingEntityRent.class);

        entityRoot.fetch("apartmentEntityRent", JoinType.INNER); // Use fetch to perform join fetch

        Predicate predicate = builder.equal(entityRoot.get("apartmentEntityRent"), apartmentEntityRent);
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