package com.multi.mariage.country.domain;

import com.multi.mariage.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_name", nullable = false, unique = true)
    private Value name;

    @OneToMany(mappedBy = "country")
    private List<Product> products = new ArrayList<>();
}