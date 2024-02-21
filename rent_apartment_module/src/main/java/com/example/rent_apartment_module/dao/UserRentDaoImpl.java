package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.rent_apartment_module.model.entity.QUserRentEntityRent.userRentEntityRent;

@Repository
@AllArgsConstructor
public class UserRentDaoImpl implements UserRentDao {

    private final EntityManager entityManager;

    public UserRentEntityRent findUserByNickName(String nickName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRentEntityRent> query = builder.createQuery(UserRentEntityRent.class);
        Root<UserRentEntityRent> entityRoot = query.from(UserRentEntityRent.class);
        query.select(entityRoot)
                .where(builder.equal(entityRoot.get("nickName"), nickName));
        return entityManager.createQuery(query).getSingleResult();
    }

    public UserRentEntityRent findUserByNickNameQueryDSL(String nickName) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        UserRentEntityRent user = queryFactory.selectFrom(userRentEntityRent)
                .where(userRentEntityRent.nickName.eq(nickName))
                .fetchOne();
        return user;
    }

    public UserRentEntityRent findUserByLogin(String login) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRentEntityRent> query = builder.createQuery(UserRentEntityRent.class);
        Root<UserRentEntityRent> entityRoot = query.from(UserRentEntityRent.class);
        query.select(entityRoot)
                .where(builder.equal(entityRoot.get("login"), login));
        UserRentEntityRent entity = entityManager.createQuery(query).getSingleResult();
        return entity;
    }

    public UserRentEntityRent findUserByLoginQueryDSL(String login) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        UserRentEntityRent user = queryFactory.selectFrom(userRentEntityRent)
                .where(userRentEntityRent.login.eq(login))
                .fetchOne();
        return user;
    }

    public List<UserRentEntityRent> findUserRentEntityByTokenIsNotNull() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRentEntityRent> query = builder.createQuery(UserRentEntityRent.class);
        Root<UserRentEntityRent> entityRoot = query.from(UserRentEntityRent.class);
        query.select(entityRoot)
                .where(builder.isNotNull(entityRoot.get("token")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<UserRentEntityRent> findUserRentEntityByQueryDSLIsNotNull() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<UserRentEntityRent> user = queryFactory.selectFrom(userRentEntityRent)
                .where(userRentEntityRent.token.isNotNull())
                .fetch();
        return user;
    }

    public UserRentEntityRent findByToken(String token) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRentEntityRent> query = builder.createQuery(UserRentEntityRent.class);
        Root<UserRentEntityRent> entityRoot = query.from(UserRentEntityRent.class);
        query.select(entityRoot)
                .where(builder.equal(entityRoot.get("token"), token));
        return entityManager.createQuery(query).getSingleResult();
    }

    public UserRentEntityRent findByTokenQueryDSL(String token) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        UserRentEntityRent user = queryFactory.selectFrom(userRentEntityRent)
                .where(userRentEntityRent.token.eq(token))
                .fetchOne();
        return user;
    }
}
