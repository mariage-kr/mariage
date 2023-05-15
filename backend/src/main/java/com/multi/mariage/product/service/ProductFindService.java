package com.multi.mariage.product.service;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.storage.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductFindService {
    private final ImageService imageService;
    private final ProductRepository productRepository;

    public ProductFindResponse findProducts() {
        List<ProductsVO> productValues = getProductValues();

        return ProductFindResponse.builder()
                .product(productValues)
                .length(productValues.size())
                .build();
    }

    private List<ProductsVO> getProductValues() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {
                    String imageUrl = imageService.getImageUrl(product.getImage().getName());
                    return ProductsVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry(), imageUrl);
                })
                .toList();
    }

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));
    }
}
