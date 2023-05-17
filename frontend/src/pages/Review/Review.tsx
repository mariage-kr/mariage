import ReviewList from '@/components/Review/ReviewList'
import * as S from './Review.styled';

function Review() {
  const profileData = {
    id: 1,
    img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/K86nd4Er00.png',
    nickname: '마리아',
    email: '#mariage@google.com',
    reviews: 1042,
    likes: 12301
  };

  // toLocaleString();

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
          <S.ProfileLeft><S.ProfileImg src={profileData.img}/></S.ProfileLeft>
          <S.ProfileRight>
            <S.NameEmail css={S.name}>{profileData.nickname}</S.NameEmail>
            <S.NameEmail css={S.email}>{profileData.email}</S.NameEmail>
            <S.Reviews>
              <S.Title>Reviews</S.Title>
              <S.Count>{profileData.reviews}</S.Count>
            </S.Reviews>
            <S.Likes>
              <S.Title>Likes</S.Title>
              <S.Count>{profileData.likes}</S.Count>
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