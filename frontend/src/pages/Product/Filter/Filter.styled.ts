import styled from '@emotion/styled';

const Container = styled.div`
  width: 100%;
  max-width: 600px;
`;

const FilterWrap = styled.div`
  width: 100%;
  margin: 30px 0;
`;

const CategoryWrap = styled.div``;

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
`;

const Star = styled.div`
  margin: 20px 0;
`;
const ABV = styled.div`
  margin: 50px 0;
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
`;
export {
  Container,
  FilterWrap,
  CategoryWrap,
  Category,
  RangeWrap,
  Star,
  ABV,
  SlideStyle,
  FilterBtn,
};
