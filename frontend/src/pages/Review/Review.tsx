import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import ReviewList from '@/components/Review/ReviewList';
import * as S from './Review.styled';
import { reviewProfileType } from '@/@types/review';
import {
  requestReviewProfile,
} from '@/apis/request/member';

function Review() {

  const [reviewProfile, setReviewProfile] = useState<reviewProfileType>({
    nickname: '',
    email: '',
    imagePath: '',
    reviews: 0,
    likes: 0,
  });

   /* 유저 정보 요청 */
   const { id } = useParams();
   const getMyInfo = async (memberId: number) => {
    await requestReviewProfile(memberId)
      .then(response => {
        setReviewProfile(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  useEffect(() => {
    const memberId: number = Number.parseInt(id!);
    getMyInfo(memberId);
   }, [id])


  // 숫자 데이터 콤마 넣기
  const reviews = reviewProfile.reviews.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  const likes = reviewProfile.likes.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  

  return (
    <S.Container>
      <S.TopNav>
        <S.NavWrapper>
          <S.Nav>작성한 리뷰</S.Nav>
          <S.Nav>좋아요한 리뷰</S.Nav>
        </S.NavWrapper>
      </S.TopNav>
      <S.Main>
        <S.Profile>
          <S.ProfileLeft><S.ProfileImg src={reviewProfile.imagePath}/></S.ProfileLeft>
          <S.ProfileRight>
            <S.NameEmail css={S.name}>{reviewProfile.nickname}</S.NameEmail>
            <S.NameEmail css={S.email}>#{reviewProfile.email}***</S.NameEmail>
            <S.Reviews>
              <S.Title>Reviews</S.Title>
              <S.Count >{reviews}</S.Count>
            </S.Reviews>
            <S.Likes>
              <S.Title>Likes</S.Title>
              <S.Count>{likes}</S.Count>
            </S.Likes>
          </S.ProfileRight>
        </S.Profile>
      </S.Main>
      <ReviewList/>
      <ReviewList/>
      <ReviewList/>
      <ReviewList/>      
    </S.Container>
  );
}

export default Review;