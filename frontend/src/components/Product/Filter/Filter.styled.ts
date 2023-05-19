import styled from '@emotion/styled';

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

const Count = styled.p`
  @media (max-width: 1000px) {
    display: none;
  }
`;

const Color = styled.span`
  font-size: 1rem;
  color: #bb2649;
`;

const FilterWrap = styled.div`
  width: 100%;
  margin: 30px 0;

  @media (max-width: 1000px) {
    margin: 0;
  }
`;

const h4 = styled.h4`
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
  margin: 10px 0;
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
    width: 50%;
  }
`;
const Overseas = styled.div`
  @media (max-width: 1000px) {
    width: 50%;
  }
`;

const p = styled.p`
  @media (max-width: 1000px) {
    margin: 10px 0;
  }
`;

const LowerCategory = styled.div``;

const Category = styled.button`
  width: auto;
  margin: 0 5px 10px 0;
  padding: 5px 10px;
  border: 2px solid #9c94d0;
  border-radius: 30px;
  background-color: transparent;

  &:hover,
  &:focus {
    background-color: #9c94d0;
    color: #fff;
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

  @media (max-width: 1000px) {
    width: 50%;
    margin: 0 10px;
    padding: 20px 0;
  }
`;
const ABV = styled.div`
  margin: 50px 0;

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

const FilterBtn = styled.button`
  width: 100px;
  padding: 5px 10px;
  border: 2px solid #9c94d0;
  border-radius: 10px;
  background: #fff;
  font-size: 1rem;

  &:hover {
    background-color: #9c94d0;
    color: #fff;
  }

  @media (max-width: 1000px) {
    display: block;
    margin: 0 auto;
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
  Count,
  Color,
  FilterWrap,
  h4,
  CategoryWrap,
  CategoryTitle,
  UpperCategory,
  Domestic,
  Overseas,
  p,
  LowerCategory,
  Category,
  RangeWrap,
  Star,
  ABV,
  SlideStyle,
  FilterBtn,
};
