package com.example.sales_apartment_module.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "rating_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingEntitySales {

    @Id
    @SequenceGenerator(name = "rating_apartment_idSequence", sequenceName = "rating_apartment_id_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_apartment_idSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "overall_rating")
    private Double overallRating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne()
    @JoinColumn(name = "apartment_entity_id")
    private ApartmentEntitySales apartmentEntity;

}
