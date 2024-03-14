package com.example.sales_apartment_module.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "booking_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntitySales {

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

    @Column(name = "people_amount")
    private Integer peopleAmount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private ApartmentEntitySales apartmentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserRentEntitySales userId;
}
