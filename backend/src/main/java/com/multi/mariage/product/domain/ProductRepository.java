package com.multi.mariage.product.domain;

import com.multi.mariage.product.domain.embedded.Name;
import com.multi.mariage.product.domain.query.ProductRepositoryCustom;
import com.multi.mariage.product.domain.query.find.ProductFindRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom, ProductFindRepositoryCustom {
    boolean existsByName(Name name);
}
