import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  width: auto;
  height: auto;
  margin: 0 auto;
`;

const CarouselCard = styled.div`
  width: 16vw;
`;

const CardContainer = styled.div`
  border: 2px solid #9C94D0;
  border-radius: 1.5vw;
  box-shadow: 0px 0px 5px #b9b9b9;
  width: 13vw;
  height: 34vh;
  margin: 0 auto;
`;

const Wrapper = styled.div`
  height: 26vh;
  margin-left: 1vh;
`;

const Inner = styled.div`
  overflow: hidden;
`;

const inner_left = css`
  float: left;
  width: 40%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
`;

const Img = styled.img`
  width: 80%;
  height: 80%;
  margin-bottom:1vh;
`;

const inner_right = css`
  border-left: 1px solid #9C94D0;
  box-sizing: border-box;
  float: right;
  width: 60%;
  height: 20.5vh;
  margin: 5.5vh auto 0;
`;

const StarRate = styled.div`
  /* border: 1px solid #b9b9b9; */
  box-sizing: border-box;
  width: 100%;
  height: 6vh;
  margin: 4vh auto 0;
  text-align: center;
`;

const StarRateText = styled.p`
  width: 100%;
  margin: 0 auto;
  font-size: 1vw;
  font-weight: bold;
`;

const Review = styled.p`
  width: 100%;
  margin: 1vh 0;
  text-align: center;
  font-size: 0.9vw;
`;

const ReviewCount = styled.span`
  color: #BB2649;
  font-size: 0.9vw;
`;

const Country = styled.div`
  width: 100%;
`;

const country_left = css`
  float: left;
  width: 30%;
  height: auto;
  text-align: right;
`;
const Flagimg = styled.img`
  width: 80%;
  height: 80%;
`;

const country_right = css`
  float: right;
  width: 70%;
  height: 4vh;
  font-size: 0.8vw;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const Bottom = styled.div`
  margin-top: 1vh;
  text-align: center;
  font-size: 1vw;
  font-weight: bold;
  letter-spacing:0.1em;
`;


export {
  Container,
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
  Country,
  country_left,
  Flagimg,
  country_right,
  Bottom
};