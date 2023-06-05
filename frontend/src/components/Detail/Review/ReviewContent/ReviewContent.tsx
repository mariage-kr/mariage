import { useCallback, useState } from 'react';

import { ReviewType } from '@/@types/review';
import { Siren } from '@/assets/svg/SVG';
import useSnack from '@/hooks/useSnack';
import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';
import ReviewImage from '@/components/Modal/ReviewImage/ReviewImage';
import LikeButton from '@/components/Button/Like/Like';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import useUserInfo from '@/hooks/useUserInfo';
import ReviewUpdateModal from './ReviewUpdateModal/ReviewUpdateModal';
import ReviewUpdate from './ReviewUpdate/ReviewUpdate';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';
import {
  requestDeleteReview,
  requestReportReview,
} from '@/apis/request/review';
import useAuth from '@/hooks/useAuth';

import * as S from './ReviewContent.styled';

type PropsType = {
  id: number;
  name: string;
  level: number;
  countryId: number;
  country: string;
};

function ReviewContent(
  review: ReviewType,
  { id, name, level, countryId, country }: PropsType,
) {
  const navigate = useNavigate();
  const { loginSnackbar, errorSnackbar } = useSnack();
  const { userInfo } = useUserInfo();
  const { isLogin } = useAuth();
  const memberId: number | undefined = userInfo?.id;

  const [isDeleted, setIsDeleted] = useState<boolean>(false);
  const [isReport, setIsReport] = useState<boolean>(false);
  const [isOpenReviewImgModal, setOpenReviewImgModal] =
    useState<boolean>(false);
  const [isOpenReviewUpdateModal, setOpenReviewUpdateModal] =
    useState<boolean>(false);

  const onClickReviewImg = useCallback(() => {
    setOpenReviewImgModal(!isOpenReviewImgModal);
  }, [isOpenReviewImgModal]);

  const onClickReviewUpdate = useCallback(() => {
    if (isLogin()) {
      setOpenReviewUpdateModal(!isOpenReviewUpdateModal);
    }
  }, [isOpenReviewUpdateModal]);

  const deleteReview = () => {
    if (!confirm('해당 리뷰를 삭제하시겠습니까?')) {
      return;
    }
    requestDeleteReview(review.id)
      .then(() => {
        setIsDeleted(true);
      })
      .catch(error => {
        errorSnackbar(error.response.data.message);
      });
  };

  const reportReview = () => {
    if (!isLogin()) {
      loginSnackbar();
      return;
    }
    confirm('해당 리뷰를 신고하시겠습니까?');
    requestReportReview(review.id)
      .then(data => {
        setIsReport(data.report);
      })
      .catch(error => {
        errorSnackbar(error.response.data.message);
      });
  };

  if (isDeleted || isReport) {
    return <div></div>;
  }

  const goReview = () => [
    navigate(`${BROWSER_PATH.REVIEW}/${review.member.id}`),
  ];

  return (
    <S.Container>
      <S.Wrapper>
        <S.Top>
          <S.TopLeft>
            <S.Profile css={S.Profile1}>
              <S.ProfileImg src={review.member.img} onClick={goReview} />
            </S.Profile>
            <S.Profile css={S.Profile2}>
              <S.Name onClick={goReview}>{review.member.nickname}</S.Name>
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
                <S.Btn css={S.updateBtn} onClick={onClickReviewUpdate}>
                  수정
                </S.Btn>
                <S.Btn css={S.deleteBtn} onClick={deleteReview}>
                  삭제
                </S.Btn>
              </S.BtnWrap>
            ) : (
              <S.BtnWrap>
                <S.Btn onClick={reportReview} title="신고하기">
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
            <S.ReviewUpdate>
              {isOpenReviewUpdateModal && (
                <ReviewUpdateModal onClickReviewUpdate={onClickReviewUpdate}>
                  <ReviewUpdate
                    id={review.id}
                    onClickReviewUpdate={onClickReviewUpdate}
                  />
                </ReviewUpdateModal>
              )}
            </S.ReviewUpdate>
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
              <S.ReviewImg onClick={onClickReviewImg}>
                <S.Img src={review.review.img} />
              </S.ReviewImg>
            )}
            {isOpenReviewImgModal && (
              <ReviewImage
                imgUrl={review.review.img}
                onChange={onClickReviewImg}
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
