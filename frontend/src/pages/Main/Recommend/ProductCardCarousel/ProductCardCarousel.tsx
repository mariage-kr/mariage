import { useState } from 'react';
import Carousel from 'react-simply-carousel';
import * as S from './ProductCardCarousel.styled';
import dummy from './ProductCardDummyData.json';
import StarRateAverage from '@/components/StarRate/Average/StarRateAverage';

const ProductCardCarousel = () => {
  const [activeSlideIndex, setActiveSlideIndex] = useState(0);

  return (
    <S.Container>
      <Carousel
        activeSlideIndex={activeSlideIndex}
        onRequestChange={setActiveSlideIndex}
        itemsToShow={4}
        itemsToScroll={1}
        autoplay={true}
        autoplayDelay={2000}
        forwardBtnProps={{
          //here you can also pass className, or any other button element attributes
          style: {
            alignSelf: 'center',
            background: 'none',
            border: 'none',
            borderRadius: '50%',
            color: '#9C94D0',
            cursor: 'pointer',
            fontSize: '2vw',
            width: 50,
            height: 50,
            lineHeight: 1,
            textAlign: 'center',
          },
          children: <span>{`>`}</span>,
        }}
        backwardBtnProps={{
          //here you can also pass className, or any other button element attributes
          style: {
            alignSelf: 'center',
            background: 'none',
            border: 'none',
            borderRadius: '50%',
            color: '#9C94D0',
            cursor: 'pointer',
            fontSize: '2vw',
            width: 50,
            height: 50,
            lineHeight: 1,
            textAlign: 'center',
          },
          children: <span>{`<`}</span>,
        }}
        responsiveProps={[
          {
            itemsToShow: 4,
            itemsToScroll: 1,
            minWidth: 768,
          },
        ]}
        speed={400}
        easing="linear"
      >
        {dummy.cards.map(card => (
          <S.CarouselCard>
          <S.CardContainer>
            <S.Wrapper>
              <S.Inner css={S.inner_left}>
                <S.Img alt="" src={card.img} />
              </S.Inner>
              <S.Inner css={S.inner_right}>
                <S.StarRate>
                  <S.StarRateText>3.6</S.StarRateText>
                  <StarRateAverage averageReviewRate={3.6}/>
                </S.StarRate>
                <S.Review><S.ReviewCount>{card.review}</S.ReviewCount> reviews</S.Review>
                <S.Country css={S.country_left}>
                  <S.Flagimg alt="" src={card.flagimg} />
                </S.Country>
                <S.Country css={S.country_right}>{card.country}</S.Country>
              </S.Inner>
            </S.Wrapper>
            <S.Bottom>{card.name}</S.Bottom>
          </S.CardContainer>
          </S.CarouselCard>
        ))} 
      </Carousel>
    </S.Container>
  );
}


export default ProductCardCarousel;