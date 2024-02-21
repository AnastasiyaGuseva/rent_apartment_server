package com.example.rent_apartment_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "booking_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntityRent {

    @Id
    @SequenceGenerator(name = "booking_info_idSequence", sequenceName = "booking_info_id_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_info_idSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "final_cost")
    private Integer finalCost;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private ApartmentEntityRent apartmentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserRentEntityRent userId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductDiscountEntityRent productId;
    // создать новые миграции booking info, дата начала
    // и конца бронирования, общая сумма, реферальные ссылки апатаменты, юзер, скидки(продукт)
}
