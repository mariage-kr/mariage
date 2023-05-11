import { useState, useRef, useMemo } from 'react';
import reviewData from './ReviewContentDummyData.json';
import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import LikeButton from '@/components/Button/Like/Like'; 
import * as S from './ReviewContent.styled';


function ReviewContent() {

  const [data, setData] = useState();

  return (
    <S.Container>
      {reviewData.reviews.map((review : any) => (
      <S.Wrapper>
        <S.Top>
          <S.TopLeft>
            <S.Profile css={S.Profile1}>
              <S.ProfileImg src={review.profileImg} />
            </S.Profile>
            <S.Profile css={S.Profile2}>
              <S.Name>{review.name}</S.Name>
              <S.RateDate>
                <StarRateAverage averageReviewRate={review.rate} />
              </S.RateDate>
              <S.RateDate>
                <S.Date>{review.date}</S.Date>
              </S.RateDate>
            </S.Profile>
          </S.TopLeft>
          <S.TopRight>
            <S.BtnWrap>
              <S.Btn css={S.updateBtn}>수정</S.Btn>
              <S.Btn css={S.deleteBtn}>삭제</S.Btn>
            </S.BtnWrap>
            <S.Like><LikeButton liked={review.like} likeCount={review.likeCount} onClick={() => console.log("추후 axios 함수가 필요합니다")}/></S.Like>
          </S.TopRight>
        </S.Top>

        <S.Bottom>
          <S.Food>
            <S.FoodImg src={review.foodImg}/>
            <S.FoodName>{review.foodName}</S.FoodName>
            <S.ReviewRateText>궁합별점 &nbsp;&nbsp;&nbsp;<S.ReviewRate>{review.rate}</S.ReviewRate>&nbsp;점</S.ReviewRateText>
          </S.Food>
          <S.Content>
            <S.ReviewText>{review.content}</S.ReviewText>
            {review.reviewImg &&
            <S.ReviewImg>
              <S.Img src={review.reviewImg}/>
            </S.ReviewImg>
            }
          </S.Content>
        </S.Bottom>
      </S.Wrapper>
      ))}
    </S.Container>
  );
};

export default ReviewContent;