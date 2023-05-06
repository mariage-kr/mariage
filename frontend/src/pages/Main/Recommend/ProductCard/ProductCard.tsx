import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';
import * as S from './ProductCard.styled';

function ProductCard({ card }: any) {
  return (
    <S.CarouselCard>
      <S.CardContainer>
        <S.Wrapper>
          <S.Inner css={S.inner_left}>
            <S.Img alt="" src={card.img} />
          </S.Inner>
          <S.Inner css={S.inner_right}>
            <S.StarRate>
              <S.StarRateText>3.6</S.StarRateText>
              <StarRateAverage averageReviewRate={3.6} />
            </S.StarRate>
            <S.Review>
              <S.ReviewCount>{card.review}</S.ReviewCount> reviews
            </S.Review>
            <S.Country css={S.country_left}>
              <S.Flagimg alt="" src={card.flagimg} />
            </S.Country>
            <S.Country css={S.country_right}>{card.country}</S.Country>
          </S.Inner>
        </S.Wrapper>
        <S.Bottom>{card.name}</S.Bottom>
      </S.CardContainer>
    </S.CarouselCard>
  );
}

export default ProductCard;
