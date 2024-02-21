package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.rent_apartment_module.model.entity.QApartmentEntityRent.apartmentEntityRent;


@Repository
@AllArgsConstructor
public class ApartmentDaoImpl implements ApartmentDao {

    private final EntityManager entityManager;

    public ApartmentEntityRent findApartmentByCriteria(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();// Интерфейс, который предоставляет вызовы для запросов
        CriteriaQuery<ApartmentEntityRent> query = builder.createQuery(ApartmentEntityRent.class); // Создание запроса, необходимо указать тип возвращаемого элемента
        Root<ApartmentEntityRent> entityRoot = query.from(ApartmentEntityRent.class); // Корневой элемент - точка начала запроса
        query.select(entityRoot)
                .where(builder.equal(entityRoot.get("id"), id));
        ApartmentEntityRent apartmentEntityRent = entityManager.createQuery(query).getSingleResult();
        return apartmentEntityRent;
    }
    public ApartmentEntityRent findApartmentByQueryDsl(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        ApartmentEntityRent apartment = queryFactory.selectFrom(apartmentEntityRent)
                .where(apartmentEntityRent.id.eq(id))
                .fetchOne();
        return apartment;
    }

    public List<ApartmentEntityRent> findApartmentByCriteria(String city) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ApartmentEntityRent> query = cb.createQuery(ApartmentEntityRent.class);
        Root<ApartmentEntityRent> root = query.from(ApartmentEntityRent.class);

        query.select(root).where(cb.equal(root.get("address").get("city"), city));

        List<ApartmentEntityRent> resultList = entityManager.createQuery(query).getResultList();

        return resultList;
    }
    public List<ApartmentEntityRent> findApartmentByQueryDsl(String city) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<ApartmentEntityRent> apartment = queryFactory.selectFrom(apartmentEntityRent)
                .where(apartmentEntityRent.address.city.eq(city))
                .fetch();
        return apartment;
    }
}
