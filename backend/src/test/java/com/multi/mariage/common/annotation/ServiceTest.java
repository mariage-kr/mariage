package com.multi.mariage.common.annotation;

import com.multi.mariage.hashtag.service.HashtagService;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review_hashtag.service.ReviewHashtagService;
import com.multi.mariage.storage.repository.StorageRepository;
import com.multi.mariage.storage.service.StorageService;
import com.multi.mariage.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class ServiceTest {
    @Autowired
    protected HashtagService hashtagService;
    @Autowired
    protected MemberFindService memberFindService;
    @Autowired
    protected MemberModifyService memberModifyService;
    @Autowired
    protected ProductFindService productFindService;
    @Autowired
    protected ProductModifyService productModifyService;
    @Autowired
    protected ReviewHashtagService reviewHashtagService;
    @Autowired
    protected StorageService storageService;
    @Autowired
    protected WeatherService weatherService;
    @Autowired
    protected StorageRepository storageRepository;

    /* TODO: 2023/05/18 회원 저장 */
    /* TODO: 2023/05/18 제품 저장 */
    /* TODO: 2023/05/18 이미지 저장 */
    /* TODO: 2023/05/18 날씨 저장 */
    /* TODO: 2023/05/18 리뷰 저장 */
}
