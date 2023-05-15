import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  border-radius: 10px;
  width: 95%;
  margin: 0 auto;
  display: block;
`;

const Title = styled.h3`
  margin: 10px 0;
  padding: 0;
`;

const TitleInfo = styled.p`
  margin: 5px 0 10px;
  padding: 0;
  font-size: 1rem;
`;

const Wrapper = styled.div`
  overflow-y: auto; 
  height: 60vh;

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
  box-sizing: border-box;
  display: inline-block;
  vertical-align: top;
`;

const country_left = css`
  width: 30px;
  height: 30px;
  box-shadow: 1px 1px #9C94D0;
  border-radius: 50%;
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
  padding: 6px 0 0 5px;
`;

const NameLevel = styled.p`
  margin: 5px 0;
  padding: 0;
  font-size: 1rem;
`;

const ABV = styled.span`
  color: #BB2649;
`;

const DrinkStarRate = styled.div`
  float: right;
  width: 30%;
  box-sizing: border-box;
  margin: 33px auto 0;
`;

const InputReview = styled.textarea`
  width: 99%;
  height: 200px;
  margin: 10px 0.5%;
  padding: 8px;
  border: none;
  border-radius: 10px;
  background-color: #9C94D044;
  box-sizing: border-box;
  box-shadow: 0 0 3px #9C94D088;
  font-size: small;
  cursor: pointer;

  &:hover,
  &:focus {
    box-shadow: 0 0 5px #9C94D0;
    outline: none;
  }

  &::placeholder {
    color: #999999;
  }
`;

const PairingText = styled.div`
  float: left;
  width: 15%;
  font-size: 1rem;
`;

const PairingStarRate = styled.div`
  float: left;
  width: 30%;
`;

const Bottom = styled.div`
  overflow: hidden;
`;

const BtnWrapper = styled.div`
  width: 100%;
  height: auto;
  padding: 0 10%;
`;

const Btn = styled.button`
  width: 30%;
  height: 40px;
  margin: 10px 5% 10px;
  border-radius: 10px;
  background-color: #fff;
  box-shadow: 0 0 3px #9C94D055;
  font-size: 1rem;
  &:hover {
    box-shadow: 0 0 4px #9C94D0;
  }
`;

const FoodContent = styled.div`
  width: 100%;
  height: auto;
`;

const HashTag = styled.div`
  width: 100%;
  height: auto;
  margin: 20px 0;
`;

const HashTagTitle = styled.p`
  font-size: 1rem;
  margin: 0;
  padding: 0;
`;

const InputHashTag = styled.input`
  width: 99%;
  height: 40px;
  margin: 10px 0.5% 0;
  padding: 5px;
  border: none;
  border-radius: 10px;
  background-color: #9C94D044;
  box-sizing: border-box;
  box-shadow: 0 0 3px #9C94D088;
  font-size: small;
  cursor: pointer;

  &:hover,
  &:focus {
    box-shadow: 0 0 5px #9C94D0;
    outline: none;
  }

  &::placeholder {
    color: #999999;
  }
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
  height: 40px;
  border-radius: 10px;
  background-color: #fff;
  box-shadow: 0 0 3px #9C94D055;
  font-size: 1rem;
  transition: 250ms;

  &:hover {
    box-shadow: 0 0 4px #9C94D0;
    transform: scale(1.02);
  }
  &:focus {
    background-color: #9C94D0;
    color: #fff;
    transform: scale(1.02);
  }
`;

const Submit = styled.div`
  box-sizing: border-box;
  float: right;
  width: 50%;
  margin: 0;
  padding: 5px 10px;
  text-align: right;
`;

const SubmitBtn = styled.button`
  width: 95%;
  height: 40px;
  border-radius: 10px;
  background-color: #fff;
  box-shadow: 0 0 3px #9C94D055;
  font-size: 1rem;
  transition: 250ms;

  &:hover {
    box-shadow: 0 0 4px #9C94D0;
    transform: scale(1.02);
  }
  &:focus {
    background-color: #9C94D0;
    color: #fff;
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
  PairingText,
  PairingStarRate,
  Bottom,
  BtnWrapper,
  Btn,
  FoodContent,
  HashTag,
  HashTagTitle,
  InputHashTag,
  FinalBtn,
  Cancel,
  CancelBtn,
  Submit,
  SubmitBtn
};