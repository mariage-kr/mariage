import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  margin: 0 auto;
  padding-top: 3vh;
`;

const Wrapper = styled.div`
  border-bottom: 1.5px solid #9C94D044;
  width: 95%;
  height: 290px;
  margin: 0 auto;
  padding: 0 0 30px 5%;
  overflow: hidden;

  @media (max-width:1170px) { padding: 0 0 50px 5%; }
`;

const Left = styled.div`
  box-sizing: border-box;
  float: left;
  width: 150px;
  height: 100%;
  margin: 0 2% 0 0;
`;

const Img = styled.img`
  width: 90%;
  height: 100%;
`;

const Right = styled.div`
  box-sizing: border-box;
  width: 70%;
  height: auto;
  padding-top: 55px;

  @media (max-width:1520px) { width: 80%; }
  @media (max-width:1320px) { width: 90%; }
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
  padding: 4px 0 0 5px;
`;

const Name = styled.p`
  margin-top: 5px;
  font-size: 1.3rem;
  font-weight: bold;
`;

const ABV = styled.p`
  margin: 8px 0 0;
  font-size: 1rem;
`;

const ABVText = styled.span`
  color: #BB2649;
  font-size: 1rem;
`;

const StarRate = styled.div`
  box-sizing: border-box;
  display: inline-block;
  margin: 5px 0 0;
  padding: 0;
  vertical-align: middle;
`;

const StarRateText = styled.p`
  margin: 0 10px 0 0;
  padding-bottom: 2px;
  font-size: 1.2rem;
  font-weight: bold;
`;


const Content = styled.div`
  box-sizing: border-box;
  margin: 10px 0 0;
  font-size: 1rem;
  letter-spacing: 0.05em;
  
`;


export {
  Container,
  Wrapper,
  Left,
  Img,
  Right,
  Country,
  country_left,
  FlagImg,
  country_right,
  Name,
  ABV,
  ABVText,
  StarRate,
  StarRateText,
  Content
};