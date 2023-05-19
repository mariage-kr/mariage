import SvgStarRateAverage from '@/components/StarRate/Average/SvgStarRateAverage';
import LikeButton from '@/components/Button/Like/Like';

import * as S from './ReviewList.styled';

function ReviewList() {
  const ProductData = {
    id: 1,
    img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/9XYNAZN4ZB.png',
    name: '산토리 위스키 가쿠빈 :suntory whisky kakubin',
    flagImg: 'https://i.esdrop.com/d/f/CeyD9bnnT5/OT0QaqYDkx.png',
    country: 'Japan',
    level: 40,
    rate: 3.8,
  };

  const ReviewData = {
    id: 1,
    profileImg: 'https://i.esdrop.com/d/f/CeyD9bnnT5/K86nd4Er00.png',
    nickname: 'maria',
    rate: 4.6,
    date: 'April 15, 2023',
    isLiked: true,
    likeCount: 10,
    foodImg: 'https://i.esdrop.com/d/f/CeyD9bnnT5/NEUdCmsFva.png',
    foodName: '돈까스/회/일식',
    reviewContent: '가격이 저렴해서 대중적이지만 아무래도 저가형 위스키인지라 스트레이트로 마셨을 때 향이 그리 우수하지 못하다. 그러다 보니 하이볼로 만들어 마시는 게 가장 맛있고, 대중적으로 알려진 것 같다. 산토리 위스키 하이볼은 탄산의 맛으로 가볍게 마시는 술이기 때문에 어떤 안주든 다 잘 어울리지만 나는 개인적으로 산토리가 일본 위스키라는 점에서 이자카야 해산물 안주가 특히 잘 어울리는 것 같다.',
    reviewImg: 'https://i.esdrop.com/d/f/CeyD9bnnT5/623HFq9M9q.jpg',
  };

  const hashTags = [
    {id: 1, value: '크리스마스'},
    {id: 2, value: '데이트'},
    {id: 3, value: '달달한'},
  ]

  return (
    <S.Container>
      <S.Wrapper>
        <S.Left>
          <S.ProductLeft>
            <S.ProductImg src={ProductData.img} />
          </S.ProductLeft>
          <S.ProductRight>
            <S.ProductName>{ProductData.name}</S.ProductName>
            <S.SubWrap>
              <S.CountryWrap css={S.media1200}>
                <S.Country css={S.country_left}>
                  <S.FlagImg src={ProductData.flagImg} />
                </S.Country>
                <S.Country css={S.country_right}>{ProductData.country}</S.Country>
              </S.CountryWrap>
              <S.ABV css={S.media1200}>
                ABV <S.ABVText>{ProductData.level}</S.ABVText>%
              </S.ABV>
              <S.ProductStarRateWrap css={S.media1200}>
                <S.ProductStarRate>
                  <S.ProductStarRateText>{ProductData.rate}</S.ProductStarRateText>
                </S.ProductStarRate>
                <S.ProductStarRate>
                  {/* TODO: 평균 별점 */}
                  <SvgStarRateAverage
                    key={ProductData.id}
                    id={ProductData.id}
                    rate={ProductData.rate}
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
                <S.ProfileImg src={ReviewData.profileImg} />
              </S.Profile>
              <S.Profile css={S.Profile2}>
                <S.Name>{ReviewData.nickname}</S.Name>
                <S.RateDate>
                  <SvgStarRateAverage
                    id={ReviewData.id}
                    key={ReviewData.id}
                    rate={ReviewData.rate}
                  />
                </S.RateDate>
                <S.RateDate>
                  <S.Date>{ReviewData.date}</S.Date>
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
                  liked={ReviewData.isLiked}
                  likeCount={ReviewData.likeCount}
                  /* TODO: 추후 AXIOS 함수로 수정 */
                  onClick={() => console.log('추후 axios 함수가 필요합니다')}
                />
              </S.Like>
            </S.ReviewTopRight>
          </S.ReviewTop>
          <S.ReviewBottom>
            <S.Food>
              <S.FoodImg src={ReviewData.foodImg} />
              <S.FoodName>{ReviewData.foodName}</S.FoodName>
            </S.Food>
            <S.Content>
              <S.ReviewText>
                <S.ReviewContentText>{ReviewData.reviewContent}</S.ReviewContentText>
                {hashTags.map(tag => (
                  <S.HashTag>#{tag.value}</S.HashTag>
                ))}
              </S.ReviewText>
              {ReviewData.reviewImg && (
                <S.ReviewImg>
                  <S.Img src={ReviewData.reviewImg} />
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