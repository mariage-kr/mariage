package com.multi.mariage.product.service;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.domain.embedded.Info;
import com.multi.mariage.product.domain.embedded.Level;
import com.multi.mariage.product.domain.embedded.Name;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ProductModifyService {
    private final ProductFindService productFindService;
    private final ImageService imageService;
    private final StorageService storageService;
    private final ProductRepository productRepository;


    public Product save(ProductSaveRequest request) {

        Name name = Name.of(request.getName());
        validateProductIsNotDuplicated(name);

        Image image = imageService.findById(request.getImageId());

        Product product = Product.builder()
                .name(Name.of(request.getName()))
                .level(Level.of(request.getLevel()))
                .info(Info.of(request.getInfo()))
                .upperCategory(request.getUpperCategory())
                .lowerCategory(request.getLowerCategory())
                .country(request.getCountry())
                .build();
        product.setImage(image);

        return productRepository.save(product);
    }

    private void validateProductIsNotDuplicated(Name name) {
        if (productRepository.existsByName(name)) {
            throw new ProductException(ProductErrorCode.SAVE_INVALID_PRODUCT);
        }
    }

    public void update(ProductUpdateRequest request) {
        Image image = imageService.findById(request.getNewImageId());

        removeProductImage(request.getImageId());

        Product product = productFindService.findById(request.getId());
        product.update(request);
        product.setImage(image);
    }

    private void removeProductImage(Long imageId) {
        Image image = storageService.findById(imageId);

        storageService.remove(image);
    }
}
