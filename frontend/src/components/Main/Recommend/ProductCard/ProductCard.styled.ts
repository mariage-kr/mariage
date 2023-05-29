import styled from '@emotion/styled';
import { css } from '@emotion/react';

const CarouselCard = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  cursor: pointer;
`;

const CardContainer = styled.div`
  margin: 0 20px 10px;
  width: 240px;
  height: 350px;

  border: 1px solid #9c94d066;
  border-radius: 10px;
  box-shadow: 3px 3px 3px #9c94d033;
  transition: 250ms;

  &:hover {
    box-shadow: 3px 3px 3px #9c94d0;
  }

  @media (min-width: 1920px) {
    margin: 0 18px 10px;
  }
`;

const Wrapper = styled.div`
  height: 260px;
  margin: 0 10px 0 8px;
`;

const Inner = styled.div`
  overflow: hidden;
`;

const inner_left = css`
  float: left;
  width: 50%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
`;

const Img = styled.img`
  width: 90%;
  height: 100%;
  margin-bottom: 10px;
`;

const inner_right = css`
  box-sizing: border-box;
  float: right;
  width: 50%;
  margin: 125px auto 0;
`;

const StarRate = styled.div`
  box-sizing: border-box;
  width: 100%;
  height: 60px;
  margin: 0 auto;
  text-align: center;
`;

const StarRateText = styled.p`
  width: 100%;
  margin: 0 auto;
  font-size: 1.2rem;
  font-weight: bold;
`;

const Review = styled.p`
  width: 100%;
  margin: 20px 0 0;
  text-align: center;
  font-size: 1.1rem;
`;

const ReviewCount = styled.span`
  color: #bb2649;
  font-size: 1rem;
`;

const Bottom = styled.div`
  margin: 0 auto;
  text-align: center;
  overflow: hidden;
`;

const Name = styled.div`
  font-size: 1.3rem;
  font-weight: bold;
  letter-spacing: 0.1em;
`;

const Country = styled.div`
  width: 100%;
  margin: 0 5px;
  display: inline-block;
  vertical-align: top;
`;

const country_left = css`
  border-radius: 50%;
  box-shadow: 1px 1px #9c94d055;
  width: 30px;
  height: 30px;
  text-align: right;
`;

const FlagImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const country_right = css`
  width: auto;
  height: auto;
  padding: 3px 0 0;
  font-size: 1rem;
`;

const StarWrapper = styled.div`
  background-color: red;
  width: 100px;
`;

export {
  CarouselCard,
  CardContainer,
  Wrapper,
  Inner,
  inner_left,
  Img,
  inner_right,
  StarRate,
  StarRateText,
  Review,
  ReviewCount,
  Bottom,
  Name,
  Country,
  country_left,
  FlagImg,
  country_right,
  StarWrapper,
};
