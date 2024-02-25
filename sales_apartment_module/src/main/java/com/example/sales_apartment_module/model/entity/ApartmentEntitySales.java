package com.example.sales_apartment_module.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "apartment_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentEntitySales {

    @Id
    @SequenceGenerator(name = "apartment_info_idSequence", sequenceName = "apartment_info_id_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_info_idSequence")
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "apartmentEntity")
    private AddressEntitySales address;

    @Column(name = "price")
    private Integer price;

    @Column(name = "rooms_count")
    private Integer roomsCount;

    @Column(name = "free_flag")
    private Boolean freeFlag;

    @Column(name="fool_rating")
    private Double foolRating;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartmentEntity")
    private List<RatingEntitySales> apartmentRating;
}
