package com.multi.mariage.product.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.service.ProductFindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductFindController {
    private final ProductFindService productFindService;

    @GetMapping("/user/product/recommend/slope")
    public ResponseEntity<List<ProductMainCardResponse>> findSlope(@Authenticated AuthMember authMember,
                                          @Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findBySlope(authMember, size);
        return ResponseEntity.ok(response);
    }

    /* TODO: 2023/05/24 테스트 코드 필요 */
    @GetMapping("/product/recommend/weather")
    public ResponseEntity<List<ProductMainCardResponse>> findWeather(@Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findWeather(size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/date")
    public ResponseEntity<List<ProductMainCardResponse>> findRecommendProducts(@Param("size") int size,
                                                                               @Param("option") String option) {
        List<ProductMainCardResponse> response = productFindService.findRecommendDate(size, option);
        return ResponseEntity.ok(response);
    }

    /* TODO: 2023/05/29 검색 기능 테스트 구현 */
    @GetMapping("/product/find/filter")
    public ResponseEntity<ProductFilterResponse> findProductsByFilter(ProductFindByFilterRequest cond) {
        ProductFilterResponse response = productFindService.findByFilter(cond);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/{id}")
    public ResponseEntity<ProductDetailPageResponse> findDetailPageById(@PathVariable Long id) {
        ProductDetailPageResponse response = productFindService.findFullInfoByPage(id);
        return ResponseEntity.ok(response);
    }

    /* TODO: 2023/05/19 추후 해당 권한은 관리자만 가능하게 할 예정입니다. */
    /* TODO: 2023/05/24 권한 부여후 테스트 코드 작성 */
    @GetMapping("/user/product/info")
    public ResponseEntity<ProductInfoResponse> findProductInfo(@Param("productId") Long productId) {
        ProductInfoResponse response = productFindService.findProductInfo(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/search")
    public ResponseEntity<ProductSearchResponse> findProductToSearch(@Param("word") String word) {
        ProductSearchResponse response = productFindService.findSearch(word);
        return ResponseEntity.ok(response);
    }
}
