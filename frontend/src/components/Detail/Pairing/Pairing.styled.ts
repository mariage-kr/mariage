import styled from '@emotion/styled';
import { css } from '@emotion/react';

type Select = {
  select: boolean;
};

const Container = styled.div`
  margin: 0 auto;
  padding: 40px 0 7vh;
`;

const Wrapper = styled.div`
  width: 95%;
  margin: 0 auto;
  overflow: hidden;
`;

const Title = styled.div`
  display: inline-block;
  width: auto;
  vertical-align: bottom;
  margin-right: 10px;
`;

const title_left = css`
  width: 40px;
  height: 40px;
`;

const TitleIcon = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const title_right = css`
  width: auto;
  height: auto;
  font-size: 1.5rem;
`;

const HashtagFilter = styled.div`
  margin: 15px 0 40px;
`;

const Button = styled.button<Select>`
  border-radius: 50px;
  width: auto;
  min-width: 78px;
  height: 40px;
  margin-right: 15px;
  padding: 0 20px;
  font-size: 1rem;

  background-color: ${prop => (prop.select ? '#9c94d0' : '#fff')};
  color: ${prop => (prop.select ? '#f8f8f8' : '#000')};
  box-shadow: 1px 1px 3px ${prop => (prop.select ? '#00000030' : '#9C94D055')};
  transition: 250ms;

  &:hover {
    box-shadow: 1.5px 1.5px 3px #9c94d0;
  }
`;

const PairingFood = styled.ul`
  margin: 0 auto;
  text-align: center;
`;

const Food = styled.li`
  list-style: none;
  display: inline-block;
  width: 17.2%;
  padding-top: 1vh;
  overflow: hidden;
  transition: all 0.2s linear;

  &:hover {
    transform: scale(1.05);
    text-shadow: 0 0 5px #9c94d099;
  }

  &:nth-of-type(1) {
    margin-right: 3%;
  }
  &:nth-of-type(2) {
    margin-right: 3%;
  }
  &:nth-of-type(3) {
    margin-right: 3%;
  }
  &:nth-of-type(4) {
    margin-right: 3%;
  }
`;

const FoodImg = styled.img`
  border-radius: 100%;
  box-shadow: 0px 0px 10px #9c94d044;
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const NameRate = styled.div`
  margin: 5px 0 0;
  display: inline-block;
  text-align: center;
  font-size: 1.1rem;

  @media (max-width: 1140px) {
    display: block;
  }
`;

const NameRate2= styled.div`
  margin: 5px 0 0;
  text-align: center;
  font-size: 1.1rem;
`;

const rate = css`
  margin-left: 15px;

  @media (max-width: 1140px) {
    margin-left: 0;
  }
`;

const Rate = styled.span`
  color: #bb2649;
  font-size: 1.2rem;
  font-weight: 600;
  margin-right: 2px;
`;

export {
  Container,
  Wrapper,
  Title,
  title_left,
  TitleIcon,
  title_right,
  HashtagFilter,
  Button,
  PairingFood,
  Food,
  FoodImg,
  NameRate,
  NameRate2,
  rate,
  Rate,
};
