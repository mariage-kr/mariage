import styled from '@emotion/styled';
import { css } from '@emotion/react';

const CarouselCard = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const CardContainer = styled.div`
  margin: 0 25px 20px 25px;

  /* TODO: VIVINO */
  width: 200px;
  height: 312px;

  /* width: 13vw; */
  /* height: 34vh; */

  border: 2px solid #9c94d0;
  /* TODO: 크기에 따라서 모서리가 달라짐 */
  border-radius: 1.5vw;
  box-shadow: 3px 3px 3px 3px #00000033;

  transition: 250ms;

  &:hover {
    box-shadow: 4px 4px 3px 3px #9c94d090;
  }
`;

const Wrapper = styled.div`
  height: 26vh;
  margin-left: 1vw;
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
  margin-bottom: 1vh;
`;

const inner_right = css`
  border-left: 1px solid #9c94d0;
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
  color: #bb2649;
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
const FlagImg = styled.img`
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
  letter-spacing: 0.1em;
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
  Country,
  country_left,
  FlagImg,
  country_right,
  Bottom,
};
