package com.multi.mariage.product.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.product.domain.embedded.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepositoryTest extends RepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        product = productRepository.save(ProductFixture.일품진로.toProduct());
    }

    @DisplayName("제품을 저장한다.")
    @Test
    void 제품을_저장한다() {
        Product expected = ProductFixture.처음처럼.toProduct();

        Product actual = productRepository.save(expected);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("해당 제품이 이미 존재하는지 확인한다.")
    @Test
    void 해당_제품이_이미_존재하는지_확인한다() {
        String name = product.getName();

        boolean actual = productRepository.existsByName(Name.of(name));

        assertThat(actual).isTrue();
    }

}
