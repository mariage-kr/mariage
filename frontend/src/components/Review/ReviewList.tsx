import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import LikeButton from '@/components/Button/Like/Like';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';
import { ReviewPageType } from '@/@types/review';

import * as S from './ReviewList.styled';

function ReviewList({ productInfo, reviewInfo }: ReviewPageType) {
  /* TODO: 버튼 링크 만들기 */
  /* TODO: 수정 기능 만들기 */
  /* TODO: 좋아요 기능 만들기 */
  /* TODO: 삭제 기능 만들기 */
  /* TODO: 사용자 인증 기능 */
  /* TODO: 신고 기능 */
  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>
          <S.ProductLeft>
            <S.ProductImg src={productInfo.imageUrl} />
          </S.ProductLeft>
          <S.ProductRight>
            <S.ProductName>{productInfo.name}</S.ProductName>
            <S.SubWrap>
              <S.CountryWrap css={S.media1200}>
                <S.Country css={S.country_left}>
                  <CountryFlagImg id={productInfo.countryId} />
                </S.Country>
                <S.Country css={S.country_right}>
                  {productInfo.country}
                </S.Country>
              </S.CountryWrap>
              <S.ABV css={S.media1200}>
                ABV <S.ABVText>{productInfo.level}</S.ABVText>%
              </S.ABV>
              <S.ProductStarRateWrap css={S.media1200}>
                <S.ProductStarRate>
                  <S.ProductStarRateText>
                    {productInfo.reviewRate}
                  </S.ProductStarRateText>
                </S.ProductStarRate>
                <S.ProductStarRate>
                  {/* TODO: 평균 별점 */}
                  <SvgStarRateAverage
                    key={productInfo.id}
                    id={productInfo.id}
                    rate={productInfo.reviewRate}
                  />
                </S.ProductStarRate>
              </S.ProductStarRateWrap>
            </S.SubWrap>
          </S.ProductRight>
        </S.Left>

        <S.Right>
          <S.ReviewTop>
            <S.ReviewTopLeft>
              <S.Profile css={S.Profile1}>
                <S.ProfileImg src={reviewInfo.member.img} />
              </S.Profile>
              <S.Profile css={S.Profile2}>
                <S.Name>{reviewInfo.member.nickname}</S.Name>
                <S.RateDate>
                  <SvgStarRateAverage
                    id={reviewInfo.id}
                    key={reviewInfo.id}
                    rate={reviewInfo.review.rate}
                  />
                </S.RateDate>
                <S.RateDate>
                  <S.Date>{reviewInfo.review.date}</S.Date>
                </S.RateDate>
              </S.Profile>
            </S.ReviewTopLeft>
            <S.ReviewTopRight>
              {/* TODO: 리뷰의 작성한 유저의 ID와 자신의 ID가 동일 할 시 보이게 */}
              <S.BtnWrap>
                {/* TODO: 수정 모달창으로 할지 고민 */}
                <S.Btn css={S.updateBtn}>수정</S.Btn>
                {/* TODO: 삭제 확인창 후 "확인"시 삭제 */}
                <S.Btn css={S.deleteBtn}>삭제</S.Btn>
              </S.BtnWrap>
              <S.Like>
                <LikeButton
                  reviewId={reviewInfo.id}
                  liked={reviewInfo.like.liked}
                  likeCount={reviewInfo.like.count}
                />
              </S.Like>
            </S.ReviewTopRight>
          </S.ReviewTop>
          <S.ReviewBottom>
            <S.Food>
              <FoodCategoryImg id={reviewInfo.food.id} />
              <S.FoodName>{reviewInfo.food.name}</S.FoodName>
            </S.Food>
            <S.Content>
              <S.ReviewText>
                <S.ReviewContentText>
                  {reviewInfo.review.content}
                </S.ReviewContentText>
                {reviewInfo.hashtags.map((tag: string, index: number) => (
                  <S.HashTag key={index}>#{tag}</S.HashTag>
                ))}
              </S.ReviewText>
              {reviewInfo.review.img && (
                <S.ReviewImg>
                  <S.Img src={reviewInfo.review.img} />
                </S.ReviewImg>
              )}
            </S.Content>
          </S.ReviewBottom>
        </S.Right>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewList;
