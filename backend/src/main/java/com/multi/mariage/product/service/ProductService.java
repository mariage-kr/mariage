package com.multi.mariage.product.service;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final StorageRepository storageRepository;

    @Transactional
    public Product create(ProductSaveRequest request) {
        //TODO: 현재 임시로 예외처리. 예외처리 및 검증 구조 따로 생성 필요.
        log.info("");
        Image image = storageRepository.findById(request.getImageId())
                .orElseThrow(() -> new IllegalArgumentException("이미지를 찾을 수 없습니다."));

        Product product = Product.builder()
                .name(request.getName())
                .level(request.getLevel())
                .info(request.getInfo())
//                .country(request.getCountry())
                .image(image)
                .build();
        product.setImage(image);

        return productRepository.save(product);
    }
}
