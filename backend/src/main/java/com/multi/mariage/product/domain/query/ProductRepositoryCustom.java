package com.multi.mariage.product.domain.query;

import com.multi.mariage.product.domain.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchProductByName(String name);
    List<Product> findTotal();
}
