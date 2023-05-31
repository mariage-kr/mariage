import styled from '@emotion/styled';
import { css } from '@emotion/react';

type Props = {
  valid: boolean;
};

const Container = styled.div`
  border-radius: 10px;
  width: 95%;
  margin: 0 auto;
  display: block;
`;

const Title = styled.h3`
  margin: 2vh 0 10px;
`;

const TitleInfo = styled.p`
  margin: 5px 0 10px;
  font-size: 1rem;
`;

const Wrapper = styled.div`
  overflow-y: auto;
  height: 62vh;

  -ms-overflow-style: none; /* 인터넷 익스플로러 */
  scrollbar-width: none; /* 파이어폭스 */

  &::-webkit-scrollbar {
    display: none; /* 크롬, 사파리, 오페라, 엣지 */
  }
`;

const Top = styled.div`
  width: 100%;
  height: auto;
  margin: 0 auto;
  padding: 10px 0;
  overflow: hidden;
`;

const DrinkInfo = styled.div`
  float: left;
  overflow: hidden;
  width: 70%;
`;

const Country = styled.div`
  display: inline-block;
  vertical-align: top;
`;

const country_left = css`
  width: 30px;
  height: 30px;
  box-shadow: 1px 1px #9c94d0;
  border-radius: 50%;
  margin: 5px;
`;

const FlagImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const country_right = css`
  width: auto;
  height: auto;
  font-size: 1rem;
  padding: 8px 0 0 5px;
`;

const NameLevel = styled.p`
  margin: 7px 0 5px 2px;
  font-size: 1rem;
`;

const ABV = styled.span`
  color: #bb2649;
`;

const DrinkStarRate = styled.div`
  float: right;
  width: 22%;
  margin: 45px auto 0;
`;

const InputReview = styled.textarea`
  width: 99%;
  height: 200px;
  margin: 10px 0.5% 0;
  padding: 8px;
  border: none;
  border-radius: 10px;
  background-color: #9c94d022;
  box-sizing: border-box;
  box-shadow: 0 0 5px #9c94d066;
  font-size: small;
  cursor: pointer;
  resize: none;

  &:hover,
  &:focus {
    box-shadow: 0 0 5px #9c94d0;
    outline: none;
  }

  &::placeholder {
    color: #999999;
  }
`;

const Bottom = styled.div`
  overflow: hidden;
`;

const BtnWrapper = styled.div`
  width: 100%;
  height: auto;
  padding: 0 10%;
`;

const Btn = styled.button<Props>`
  width: 30%;
  height: 42px;
  margin: 10px 5% 10px;
  border-radius: 10px;
  background-color: ${props => (props.valid ? '#9c94d0' : '#fff')};
  box-shadow: ${props =>
    props.valid ? '0 0 5px #b9b9b9' : '0 0 3px #9c94d055'};
  color: ${props => (props.valid ? '#fff' : '#000')};
  font-size: 1rem;
  &:hover {
    box-shadow: 0 0 5px #9c94d0;
  }
`;

const FoodCategoryPrint = styled.p`
  margin: 10px 0;
  font-size: 1rem;
  text-align: center;
`;

const FoodCategorySpan = styled.span`
  color: #bb2649;
`;

const FoodContent = styled.div`
  width: 100%;
  height: auto;
`;

const Pairing = styled.div`
  margin: 10px 0;
  overflow: hidden;
`;

const PairingText = styled.div`
  float: left;
  width: 22%;
  font-size: 1rem;
`;
const PairingOption = styled.span`
  color: #bb2649;
  font-size: 0.8rem;
`;

const PairingStarRate = styled.div`
  float: left;
  width: 30%;
`;

const HashTag = styled.div`
  width: 100%;
  height: auto;
  margin: 15px 0 20px;
`;

const HashTagTitle = styled.p`
  font-size: 1rem;
  margin: 0;
  padding: 0;
`;

const FinalBtn = styled.div`
  width: 100%;
  height: auto;
`;

const Cancel = styled.div`
  box-sizing: border-box;
  float: left;
  width: 50%;
  margin: 0;
  padding: 5px;
  text-align: left;
`;

const CancelBtn = styled.button`
  width: 95%;
  height: 42px;
  border-radius: 10px;
  background-color: #fff;
  box-shadow: 0 0 5px #9c94d088;
  font-size: 1rem;
  transition: 250ms;

  &:hover {
    box-shadow: 0 0 4px #9c94d0;
    transform: scale(1.02);
  }
  &:focus {
    transform: scale(1.02);
  }
`;

const Submit = styled.div`
  box-sizing: border-box;
  float: right;
  width: 50%;
  margin: 0;
  padding: 5px;
  text-align: right;
`;

const SubmitBtn = styled.button`
  width: 95%;
  height: 42px;
  border-radius: 10px;
  background-color: #9c94d0;
  box-shadow: 0 0 5px #b9b9b9;
  color: #fff;
  font-size: 1rem;
  transition: 250ms;

  &:hover {
    box-shadow: 0 0 4px #9c94d0;
    transform: scale(1.02);
  }
  &:focus {
    transform: scale(1.02);
  }
`;

export {
  Container,
  Title,
  TitleInfo,
  Wrapper,
  Top,
  DrinkInfo,
  Country,
  country_left,
  FlagImg,
  country_right,
  NameLevel,
  ABV,
  DrinkStarRate,
  InputReview,
  Bottom,
  BtnWrapper,
  Btn,
  FoodCategoryPrint,
  FoodCategorySpan,
  FoodContent,
  Pairing,
  PairingText,
  PairingOption,
  PairingStarRate,
  HashTag,
  HashTagTitle,
  FinalBtn,
  Cancel,
  CancelBtn,
  Submit,
  SubmitBtn,
};
