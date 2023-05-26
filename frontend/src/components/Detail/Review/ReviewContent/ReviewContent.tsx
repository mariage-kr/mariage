import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';

import LikeButton from '@/components/Button/Like/Like';
import { ReviewType } from '@/@types/review';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import useUserInfo from '@/hooks/useUserInfo';

import * as S from './ReviewContent.styled';
import { useCallback, useState } from 'react';
import ReviewImage from '@/components/Modal/ReviewImage/ReviewImage';

function ReviewContent(review: ReviewType) {
  const { userInfo } = useUserInfo();

  const memberId: number | undefined = userInfo?.id;

  const [isOpenModal, setOpenModal] = useState<boolean>(false);

  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
  }, [isOpenModal]);

  console.log(isOpenModal);

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
                  rate={review.review.rate}
                />
              </S.RateDate>
              <S.RateDate>
                <S.Date>{review.review.date}</S.Date>
              </S.RateDate>
            </S.Profile>
          </S.TopLeft>
          <S.TopRight>
            {memberId === review.member.id && (
              <S.BtnWrap>
                {/* TODO: 수정 모달창으로 할지 고민 */}
                <S.Btn css={S.updateBtn}>수정</S.Btn>
                {/* TODO: 삭제 확인창 후 "확인"시 삭제 */}
                <S.Btn css={S.deleteBtn}>삭제</S.Btn>
              </S.BtnWrap>
            )}
            <S.Like>
              <LikeButton
                liked={review.like.liked}
                likeCount={review.like.count}
                /* TODO: 추후 AXIOS 함수로 수정 */
                onClick={() => console.log('추후 axios 함수가 필요합니다')}
              />
            </S.Like>
          </S.TopRight>
        </S.Top>
        <S.Bottom>
          <S.Food>
            <FoodCategoryImg id={review.food.id} />
            <S.FoodName>{review.food.name}</S.FoodName>
            <S.ReviewRateText>
              궁합별점 &nbsp;&nbsp;&nbsp;
              <S.ReviewRate>{review.food.rate}</S.ReviewRate>&nbsp;점
            </S.ReviewRateText>
          </S.Food>
          <S.Content>
            <S.ReviewText>
              <S.ReviewContentText>{review.review.content}</S.ReviewContentText>
              {review.hashtags.map((hashtag: string) => (
                <S.HashTag>#{hashtag}</S.HashTag>
              ))}
            </S.ReviewText>
            {review.review.img && (
              <S.ReviewImg onClick={onClickToggleModal}>
                <S.Img src={review.review.img} />
              </S.ReviewImg>
            )}
            {isOpenModal && (
              <ReviewImage
                imgUrl={review.review.img}
                onChange={onClickToggleModal}
                hashtags={review.hashtags}
              />
            )}
          </S.Content>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewContent;
