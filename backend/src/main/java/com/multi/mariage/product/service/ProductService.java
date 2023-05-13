package com.multi.mariage.product.service;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.storage.service.StorageService;
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
    private final StorageService storageService;

    @Transactional
    public Product save(ProductSaveRequest request) {
        Image image = imageService.findById(request.getImageId());

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

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    private Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void update(ProductUpdateRequest request) {
        Image image = imageService.findById(request.getNewImageId());

        removeProductImage(request.getImageId());

        Product product = findById(request.getId());
        product.update(request);
        product.setImage(image);
    }

    private void removeProductImage(Long imageId) {
        Image image = storageService.findById(imageId);

        storageService.remove(image);
    }
}
