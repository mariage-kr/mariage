package com.multi.mariage.product.service;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.storage.domain.Image;
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
public class ProductService {
    private final ProductRepository productRepository;
    private final ImageService imageService;

    @Transactional
    public Product save(ProductSaveRequest request) {
        Image image = imageService.findById(request);

        Product product = Product.builder()
                .name(request.getName())
                .level(request.getLevel())
                .info(request.getInfo())
                .upperCategory(request.getUpperCategory())
                .lowerCategory(request.getLowerCategory())
                .country(request.getCountry())
                .build();
        product.setImage(image);

        return productRepository.save(product);
    }

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
                .map(product -> ProductsVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry()))
                .toList();
    }

    public ProductInfoResponse findProductInfo(String productId) {
        Long id = convertStringToLong(productId);

        Product product = findById(id);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    private Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    private Long convertStringToLong(String productId) {
        System.out.println("productId = " + productId);
        try {
            return Long.parseLong(productId);
        } catch (Exception e) {
            // TODO: 제품의 아이디가 숫자가 아님
            throw new RuntimeException();
        }
    }
}
