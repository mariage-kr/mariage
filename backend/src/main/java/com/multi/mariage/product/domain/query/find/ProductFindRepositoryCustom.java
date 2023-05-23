package com.multi.mariage.product.domain.query.find;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.condition.FilterCond;

import java.util.List;

public interface ProductFindRepositoryCustom {
    List<Product> findProducts(FilterCond cond);
}
