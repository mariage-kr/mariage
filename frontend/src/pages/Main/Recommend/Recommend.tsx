import { useState } from 'react';
import * as S from './Recommend.styled';
import ProductCardCarousel from './ProductCardCarousel/ProductCardCarousel';

const Recommend = () => {
  const [message, setMessage] = useState('');
  const [weather, setWeather] = useState('맑은날');

  return (
    <S.Container>
      <S.Top>
        <S.TopLeft>
          <S.Title>술 추천</S.Title>
          <S.Filter>
            <S.ButtonWrapper>
              <S.Button
                id="weather"
                onClick={() => {
                  setMessage(`${weather}에 가장 인기 있는 술의 리뷰들 입니다!`);
                }}
              >
                날씨
              </S.Button>
              <S.Button
                id="total"
                onClick={() => {
                  setMessage('모든 술의 리뷰들 입니다!');
                }}
              >
                전체
              </S.Button>
              <S.Button
                id="weekly"
                onClick={() => {
                  setMessage('최근 1주간 가장 인기 있는 술의 리뷰들 입니다!');
                }}
              >
                1주
              </S.Button>
              <S.Button
                id="monthly"
                onClick={() => {
                  setMessage('최근 1달간 가장 인기 있는 술의 리뷰들 입니다!');
                }}
              >
                1달
              </S.Button>
            </S.ButtonWrapper>
            <S.InfoMessageWrapper>
              <S.InfoMessage>{message}</S.InfoMessage>
            </S.InfoMessageWrapper>
          </S.Filter>
        </S.TopLeft>
        <S.TopRight>날씨 Lottie</S.TopRight>
      </S.Top>
      <ProductCardCarousel />
    </S.Container>
  );
};

export default Recommend;
