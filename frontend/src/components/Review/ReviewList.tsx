import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { ReviewPageType } from '@/@types/review';
import CountryFlagImg from '@/assets/CountryFlag/CountryFlag';
import FoodCategoryImg from '@/assets/FoodCategory/FoodCategoryImg';
import { Siren } from '@/assets/svg/SVG';
import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import LikeButton from '@/components/Button/Like/Like';
import { BROWSER_PATH } from '@/constants/path';
import { SORT } from '@/constants/option';
import useUserInfo from '@/hooks/useUserInfo';
import useAuth from '@/hooks/useAuth';
import useSnack from '@/hooks/useSnack';
import {
  requestDeleteReview,
  requestReportReview,
} from '@/apis/request/review';

import * as S from './ReviewList.styled';

function ReviewList({ productInfo, reviewInfo }: ReviewPageType) {
  const navigate = useNavigate();
  const { loginSnackbar, errorSnackbar, infoSnackbar } = useSnack();
  const { userInfo } = useUserInfo();

  const goProduct = () => {
    navigate(
      `${BROWSER_PATH.DETAIL}/${productInfo.id}?sort=${SORT.DETAIL.LIKE}`,
    );
  };

  /* TODO: 수정 기능 만들기 */

  /* 삭제 기능 만들기 */
  const [isDeleted, setIsDeleted] = useState<boolean>(false);
  const deleteReview = async () => {
    if (!confirm('해당 리뷰를 삭제하시겠습니까?')) {
      infoSnackbar('리뷰 삭제를 취소하셨습니니다.');
      return;
    }

    requestDeleteReview(reviewInfo.id)
      .then(() => {
        setIsDeleted(true);
        infoSnackbar('해당 리뷰를 삭제하셨습니다.');
      })
      .catch(error => {
        errorSnackbar(error.response.data.message);
      });
  };

  /* 신고 기능 */
  const { isLogin } = useAuth();
  const [isReport, setIsReport] = useState<boolean>(false);
  const reportReview = () => {
    if (!isLogin()) {
      loginSnackbar();
      return;
    }
    confirm('해당 리뷰를 신고하시겠습니까?');
    requestReportReview(reviewInfo.id)
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

  const goReview = () => {
    navigate(`${BROWSER_PATH.REVIEW}/${reviewInfo.member.id}`);
    window.location.reload();
  };

  return (
    <S.Container>
      <S.Wrapper>
        <S.Left onClick={goProduct}>
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
                <S.ProfileImg src={reviewInfo.member.img} onClick={goReview} />
              </S.Profile>
              <S.Profile css={S.Profile2}>
                <S.Name onClick={goReview}>{reviewInfo.member.nickname}</S.Name>
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
              {userInfo?.id === reviewInfo.member.id ? (
                <S.BtnWrap>
                  {/* TODO: 수정 모달창으로 할지 고민 */}
                  <S.Btn>수정</S.Btn>
                  <S.Btn onClick={deleteReview}>삭제</S.Btn>
                </S.BtnWrap>
              ) : (
                <S.BtnWrap>
                  <S.Btn
                    onClick={reportReview}
                    css={S.BtnHeight}
                    title="신고하기"
                  >
                    <Siren fill="#bb2649" />
                  </S.Btn>
                </S.BtnWrap>
              )}
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
