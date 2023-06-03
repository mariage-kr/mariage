import { useCallback, useState } from 'react';

import { ReviewType } from '@/@types/review';
import siren from '@/assets/png/Siren.png';
import { Siren } from '@/assets/svg/SVG';

import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';
import ReviewImage from '@/components/Modal/ReviewImage/ReviewImage';
import LikeButton from '@/components/Button/Like/Like';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import useUserInfo from '@/hooks/useUserInfo';

import * as S from './ReviewContent.styled';
import {
  requestDeleteReview,
  requestReportReview,
} from '@/apis/request/review';
import useAuth from '@/hooks/useAuth';

function ReviewContent(review: ReviewType) {
  const { userInfo } = useUserInfo();
  const { isLogin } = useAuth();
  const memberId: number | undefined = userInfo?.id;

  const [isDeleted, setIsDeleted] = useState<boolean>(false);
  const [isReport, setIsReport] = useState<boolean>(false);
  const [isOpenModal, setOpenModal] = useState<boolean>(false);
  const onClickToggleModal = useCallback(() => {
    setOpenModal(!isOpenModal);
  }, [isOpenModal]);

  const deleteReview = () => {
    requestDeleteReview(review.id)
      .then(response => {
        setIsDeleted(true);
        console.log(response);
      })
      .catch(error => {
        console.error(error);
      });
  };

  const reportReview = () => {
    if (!isLogin()) {
      alert('로그인이 필요합니다.');
      return;
    }
    confirm('해당 리뷰를 신고하시겠습니까?');
    requestReportReview(review.id)
      .then(data => {
        setIsReport(data.report);
      })
      .catch(error => {
        console.log(error);
      });
  };

  if (isDeleted || isReport) {
    return <div></div>;
  }

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
            {memberId === review.member.id ? (
              <S.BtnWrap>
                {/* TODO: 수정 모달창으로 할지 고민 */}
                <S.Btn>수정</S.Btn>
                <S.Btn onClick={deleteReview}>삭제</S.Btn>
              </S.BtnWrap>
            ) : (
              <S.BtnWrap>
                <S.Btn onClick={reportReview} title="신고하기">
                  {/* <S.SirenIcon src={siren}/> */}
                  <Siren fill="#bb2649" />
                </S.Btn>
              </S.BtnWrap>
            )}
            <S.Like>
              <LikeButton
                reviewId={review.id}
                liked={review.like.liked}
                likeCount={review.like.count}
              />
            </S.Like>
          </S.TopRight>
        </S.Top>
        <S.Bottom>
          {review.food && (
            <S.Food>
              <FoodCategoryImg id={review.food.id} />
              <S.FoodName>{review.food.name}</S.FoodName>
              <S.ReviewRateText>
                궁합별점 &nbsp;&nbsp;&nbsp;
                <S.ReviewRate>{review.food.rate}</S.ReviewRate>&nbsp;점
              </S.ReviewRateText>
            </S.Food>
          )}
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
