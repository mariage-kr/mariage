import styled from '@emotion/styled';
import { css } from '@emotion/react';

type Props = {
  valid: boolean;
};

const Container = styled.div`
  width: 100%;

  @media (max-width: 1000px) {
    display: flex;
    flex-flow: wrap;
    padding: 25px;
    box-sizing: border-box;
    border: 5px solid #9c94d080;
    background-color: #fff;
    border-radius: 30px;
    color: #000;
  }
`;

const FilterWrap = styled.div`
  margin-top: -25px;
  width: 100%;
  @media (max-width: 1000px) {
    margin: 0;
  }
`;

const h4 = styled.h4`
  margin: 0;
  @media (max-width: 1000px) {
    display: none;
  }
`;

const CategoryWrap = styled.div`
  @media (max-width: 1000px) {
  }
`;

const CategoryTitle = styled.h4`
  width: 100%;
  margin: 20px 0 10px;

  @media (max-width: 1000px) {
    margin: 0;
  }
`;

const UpperCategory = styled.div`
  @media (max-width: 1000px) {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
  }
`;

const Domestic = styled.div`
  @media (max-width: 1000px) {
    width: 45%;
    margin-left: 2%;
  }
`;
const Overseas = styled.div`
  @media (max-width: 1000px) {
    width: 50%;
  }
`;

const p = styled.p`
  margin: 0 0 10px;
  font-size: 1rem;

  @media (max-width: 1000px) {
    margin: 10px 0 0;
  }
`;

const p2 = css`
  margin-top: 10px;
`;

const LowerCategory = styled.div`
  @media (max-width: 1000px) {
    margin-top: 30px;
  }
`;

const LowerCategoryWrap = styled.div`
  @media (max-width: 1000px) {
    margin-left: 2%;
  }
`;

const Category = styled.button<Props>`
  width: auto;
  margin: 0 7px 10px 0;
  padding: 5px 10px 6px;
  border: 2px solid #9c94d0;
  border-radius: 30px;
  background-color: ${props => (props.valid ? '#9c94d0' : '#fff')};
  color: ${props => (props.valid ? '#fff' : '#000')};

  &:hover {
    background-color: #9c94d0;
    color: #fff;
  }

  @media (max-width: 1000px) {
    margin: 10px 7px 0 0;
  }
`;

const RangeWrap = styled.div`
  width: 100%;
  margin: 30px 0;

  @media (max-width: 1000px) {
    display: flex;
    text-align: center;
    border-top: 1px solid #00000033;
  }
`;

const Star = styled.div`
  margin: 20px 0;
  font-size: 1rem;

  @media (max-width: 1000px) {
    width: 50%;
    margin: 0 10px 0 0;
    padding: 20px 0;
  }
`;
const ABV = styled.div`
  margin: 50px 0;
  font-size: 1rem;

  @media (max-width: 1000px) {
    width: 50%;
    margin: 0;
    padding: 20px 0;
  }
`;

const SlideStyle = styled.div`
  width: 240px;
  margin: 0;
  border: 0;
`;

const BtnWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  width: 100%;
  padding-top: 20px;

  @media (max-width: 1000px) {
    margin: 0 auto 10px;
    text-align: center;
  }
`;

const FilterBtn = styled.button`
  width: 100px;
  margin-right: 15px;
  padding: 5px 10px 6px;
  border: 2px solid #9c94d0;
  border-radius: 10px;
  background: #fff;
  font-size: 1rem;
  cursor: pointer;

  &:hover {
    background-color: #9c94d0;
    color: #fff;
  }

  @media (max-width: 1200px) {
    width: 90px;
    margin-right: 7px;
    padding: 5px 7px 6px;
  }

  @media (max-width: 1000px) {
    width: 200px;
    margin: 0 20px;
    padding: 10px 0;
    font-weight: bold;

    &:hover {
      background-color: #9c94d0;
      border-color: #eee;
      color: #fff;
    }
  }
`;
export {
  Container,
  FilterWrap,
  h4,
  CategoryWrap,
  CategoryTitle,
  UpperCategory,
  Domestic,
  Overseas,
  p,
  p2,
  LowerCategory,
  LowerCategoryWrap,
  Category,
  RangeWrap,
  Star,
  ABV,
  SlideStyle,
  BtnWrap,
  FilterBtn,
};
