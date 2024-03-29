package com.example.rent_apartment_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRentEntityRent {

    @Id
    @SequenceGenerator(name = "user_info_idSequence", sequenceName = "user_info_id_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_idSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    @Column(name = "booking_count")
    private Integer bookingCount;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

}
