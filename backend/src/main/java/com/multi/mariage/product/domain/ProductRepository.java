package com.multi.mariage.product.domain;

import com.multi.mariage.product.domain.embedded.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProduct(Name name);
}
