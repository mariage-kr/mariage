package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//리뷰 수정의 경우 UI구성이 만들어지지 않음.(시간나면 추가 할 부분)

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewUpdateRequest {

    private Long id;
    private int productScore;
    private String productContent;
    private String foodContent;
    private int foodScore;
    private LocalDateTime date;
    private FoodCategory foodCategory;
    private Hashtag hashtag;

}