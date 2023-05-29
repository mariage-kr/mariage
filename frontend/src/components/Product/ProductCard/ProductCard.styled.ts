import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  position: relative;
  display: flex;
  justify-content: flex-start;
  flex-wrap: nowrap;
  align-items: center;
  width: 100%;
  margin: 50px 0;
  padding: 20px;
  box-sizing: border-box;
  border: 1px solid #ddd;
  border-radius: 30px;
  transition: all 0.2s;
  cursor: pointer;

  &:hover {
    box-shadow: 0px 8px 10px #00000050;
  }

  &:hover > div {
    :first-child {
      transition: all 0.25s;
      transform: scale(1.1);
    }
  }

  @media (max-width: 1200px) {
    justify-content: space-around;
  }
`;

const Image = styled.div`
  width: 180px;
  margin: 0 0 30px 30px;

  @media (max-width: 1200px) {
    width: 40%;
  }
`;

const Img = styled.img`
  width: 70%;
  height: 70%;
  min-width: 90px;
  transform: scale(1.3);

  @media (max-width: 1200px) {
    min-width: 170px;
    transform: scale(1.1);
  }
`;

const Content = styled.div`
  width: 60%;
  margin: 30px 0 0;
  padding: 0;

  @media (max-width: 1200px) {
    width: 55%;
    padding: 60px 0 0;
    margin: 80px 0 0;
  }
`;

const CountryWrap = styled.div`
  display: flex;
  align-items: center;
  margin: 10px 0;
  font-size: 1rem;
`;

const CountryImgWrapper = styled.div`
  width: 35px;
  height: 35px;
  border-radius: 100%;
  box-shadow: 0px 0px 10px #9c94d044;
  object-fit: cover;
`;

const Country = styled.p`
  margin: 0 10px;
`;

const Name = styled.h3`
  width: 100%;
  margin: 10px 0;
`;

const ABV = styled.span`
  color: #bb2649;
  font-size: 1rem;
`;

const ABVSlide = styled.input`
  width: 80%;
  accent-color: #bb2649;

  @media (max-width: 1500px) {
    width: 90%;
  }
`;

const p = styled.p`
  margin: 20px 0 5px;
  font-size: 1rem;

  @media (max-width: 1200px) {
    margin: 10px 0 3px;
  }
`;

const FoodWrap = styled.ul`
  display: flex;
  padding: 0;
  margin: 20px 0 0;

  @media (max-width: 1300px) {
    margin: 10px 0 0;
  }
`;

const Food = styled.li`
  width: 110px;
  height: auto;
  list-style: none;
  text-align: center;
  margin: 0;

  @media (max-width: 1300px) {
    width: 90px;
  }
`;

const FoodImg = styled.div`
  width: 90px;
  margin: 0 10px;

  @media (max-width: 1300px) {
    width: 70px;
  }
`;

const FoodName = styled.p`
  margin: 0;
  font-size: 1rem;

  @media (max-width: 1300px) {
    font-size: 0.9rem;
  }
`;

const StarWrap = styled.div`
  width: 20%;

  @media (max-width: 1200px) {
    position: absolute;
    top: 13%;
    right: 10%;
    width: 45%;
  }
`;

const Star = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  width: 90%;
  margin: 0 auto;
  text-align: center;

  @media (max-width: 1200px) {
    display: flex;
    width: 60%;
  }
`;

const StarRateText = styled.p`
  margin: 5px auto;
  font-size: 1.5rem;
  font-weight: bold;

  @media (max-width: 1200px) {
    margin: 0;
    font-size: 2rem;
  }
`;

const Review = styled.p`
  margin: 8px 0;
  text-align: center;
  font-size: 0.9rem;
`;



export {
  Container,
  Image,
  Img,
  Content,
  CountryWrap,
  FlagImg,
  Country,
  Name,
  ABV,
  ABVSlide,
  p,
  FoodWrap,
  Food,
  FoodImg,
  FoodName,
  StarWrap,
  Star,
  StarRateText,
  Review,
  CountryImgWrapper,
};
