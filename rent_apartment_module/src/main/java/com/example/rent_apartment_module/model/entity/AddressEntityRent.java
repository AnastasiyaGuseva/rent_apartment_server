package com.example.rent_apartment_module.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "address_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntityRent {

    @Id
    @SequenceGenerator(name = "address_apartment_idSequence", sequenceName = "address_apartment_id_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_apartment_idSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "home_number")
    private String homeNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private ApartmentEntityRent apartmentEntityRent;

}
