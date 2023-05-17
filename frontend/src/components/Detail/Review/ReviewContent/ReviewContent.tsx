import LikeButton from '@/components/Button/Like/Like';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';

import { ReviewType } from '@/@types/review';

import * as S from './ReviewContent.styled';

function ReviewContent(review: ReviewType) {
  const hashTags = [
    { id: 1, value: '크리스마스' },
    { id: 2, value: '데이트' },
    { id: 3, value: '달달한' },
  ];

  return (
    <S.Container>
      <S.Wrapper>
        <S.Top>
          <S.TopLeft>
            <S.Profile css={S.Profile1}>
              <S.ProfileImg src={review.member.img} />
            </S.Profile>
            <S.Profile css={S.Profile2}>
              <S.Name>{review.member.nickname}</S.Name>
              <S.RateDate>
                <SvgStarRateAverage
                  key={review.id}
                  id={review.id}
                  rate={review.content.rate}
                />
              </S.RateDate>
              <S.RateDate>
                <S.Date>{review.content.data}</S.Date>
              </S.RateDate>
            </S.Profile>
          </S.TopLeft>
          <S.TopRight>
            {/* TODO: 리뷰의 작성한 유저의 ID와 자신의 ID가 동일 할 시 보이게 */}
            <S.BtnWrap>
              {/* TODO: 수정 모달창으로 할지 고민 */}
              <S.Btn css={S.updateBtn}>수정</S.Btn>
              {/* TODO: 삭제 확인창 후 "확인"시 삭제 */}
              <S.Btn css={S.deleteBtn}>삭제</S.Btn>
            </S.BtnWrap>
            <S.Like>
              <LikeButton
                liked={review.like.isLiked}
                likeCount={review.like.likeCount}
                /* TODO: 추후 AXIOS 함수로 수정 */
                onClick={() => console.log('추후 axios 함수가 필요합니다')}
              />
            </S.Like>
          </S.TopRight>
        </S.Top>
        <S.Bottom>
          <S.Food>
            <S.FoodImg src={review.food.img} />
            <S.FoodName>{review.food.name}</S.FoodName>
            <S.ReviewRateText>
              궁합별점 &nbsp;&nbsp;&nbsp;
              <S.ReviewRate>{review.food.rate}</S.ReviewRate>&nbsp;점
            </S.ReviewRateText>
          </S.Food>
          <S.Content>
            <S.ReviewText>
              <S.ReviewContentText>
                {review.content.content}
              </S.ReviewContentText>
              {hashTags.map(tag => (
                <S.HashTag>#{tag.value}</S.HashTag>
              ))}
            </S.ReviewText>
            {review.content.img && (
              <S.ReviewImg>
                <S.Img src={review.content.img} />
              </S.ReviewImg>
            )}
          </S.Content>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewContent;
