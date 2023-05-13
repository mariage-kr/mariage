package com.multi.mariage.product.service;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.domain.embedded.Info;
import com.multi.mariage.product.domain.embedded.Level;
import com.multi.mariage.product.domain.embedded.Name;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
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
        if (productRepository.existsByProduct(name)) {
            throw new ProductException(ProductErrorCode.SAVE_INVALID_PRODUCT);
        }
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
                .map(product -> {
                    Image image = product.getImage();
                    String fileName = image.getName();
                    String imageUrl = storageService.getFilePath(fileName);
                    return ProductsVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry(), imageUrl);
                })
                .toList();
    }

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    private Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));
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
