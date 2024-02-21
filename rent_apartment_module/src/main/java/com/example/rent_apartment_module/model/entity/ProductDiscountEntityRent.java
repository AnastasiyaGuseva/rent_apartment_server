package com.example.rent_apartment_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "discount_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDiscountEntityRent {

    @Id
    @SequenceGenerator(name = "discount_info_idSequence", sequenceName = "discount_info_id_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_info_idSequence")
    @Column(name = "id")
    private Long id;

    @Column(name="discount_description")
    private String discountDescription;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name="is_discount_active")
    private Boolean isDiscountActive;

}
