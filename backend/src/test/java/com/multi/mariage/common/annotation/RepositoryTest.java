package com.multi.mariage.common.annotation;

import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public abstract class RepositoryTest {
    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected StorageRepository storageRepository;

    protected Product saveProduct(ProductFixture productFixture) {
        Product product = productFixture.toProduct();

        Image image = storageRepository.save(new Image(productFixture.getImageName()));
        product.setImage(image);

        return productRepository.save(product);
    }
}
