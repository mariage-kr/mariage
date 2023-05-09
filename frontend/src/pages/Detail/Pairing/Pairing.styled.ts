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
  /* border: 1px solid green; */
  width: 95%;
  margin: 0 auto;
  padding: 0;
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
box-shadow: 1px 1px 3px ${prop => (prop.select ? '#00000030' : '#00000030')};
transition: 250ms;

&:hover {
  box-shadow: 1.5px 1.5px 3px #00000090;
}
`;

const PairingFood = styled.ul`
  margin: 0 auto;
  padding: 0;
  text-align: center;
`;

const Food = styled.li`
  list-style: none;
  box-sizing: border-box;
  display: inline-block;
  width: 17.2%;
  transition: all 0.2s linear;

  &:hover { 
    transform: scale(1.05); 
    /* font-weight: bold; */
    text-shadow: 2px 2px 2px #9c94d077; 
  }

  &:nth-of-type(1) { margin-right: 3%; }
  &:nth-of-type(2) { margin-right: 3%; }
  &:nth-of-type(3) { margin-right: 3%; }
  &:nth-of-type(4) { margin-right: 3%; }
`;

const FoodImg = styled.img`
  border-radius: 100%;
  box-shadow: 0px 0px 10px #9c94d044;
  width: 100%;
  height: 100%;
  object-fit: cover;
  
`;

const Name = styled.p`
  text-align: center;
  font-size: 1.1rem;
`;

const Rate = styled.span`
  margin-left: 15px;
  color: #bb2649;

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
  Name,
  Rate
};