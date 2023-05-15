import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  justify-content: flex-start;
  flex-flow: row wrap;
  align-items: center;
  width: 100%;
  margin: 50px 0;
  padding: 20px;
  box-sizing: border-box;
  border: 1px solid #ddd;
  border-radius: 30px;
  transition: all 0.2s;

  &:hover {
    box-shadow: 0px 8px 10px #00000050;
  }

  &:hover > div {
    :first-child {
      transition: all 0.25s;
      transform: scale(1.1);
    }
  }
`;

const Image = styled.div`
  width: 13%;
`;

const Img = styled.img`
  width: 100%;
`;

const Content = styled.div`
  width: 60%;
  padding: 20px 0 0 40px;
`;

const CountryWrap = styled.div`
  display: flex;
  align-items: center;
`;

const FlagImg = styled.img`
  width: 30px;
  height: 30px;
  border: 1px solid #ddd;
  border-radius: 50%;
`;

const Country = styled.p`
  margin: 0 10px;
`;

const Name = styled.h3`
  margin: 10px 0;
`;

const ABV = styled.span`
  color: #bb2649;
  font-size: 1rem;
`;

const ABVSlide = styled.input`
  width: 80%;
  accent-color: #bb2649;
`;

const FoodWrap = styled.ul`
  display: flex;
  margin-top: 30px;
  padding: 0;
`;

const Food = styled.li`
  width: 80px;
  height: 80px;
  list-style: none;
`;

const FoodImg = styled.img`
  width: 30px;
`;

const FoodName = styled.p`
  margin: 5px 0;
`;

const StarWrap = styled.div`
  width: 20%;
`;

const Star = styled.div`
  width: 90%;
  margin: 0 auto;
  text-align: center;
`;

const StarRateText = styled.p`
  margin: 5px auto;
  font-size: 1.5rem;
  font-weight: bold;
`;

const Review = styled.p`
  margin: 5px 0;
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
  FoodWrap,
  Food,
  FoodImg,
  FoodName,
  StarWrap,
  Star,
  StarRateText,
  Review,
};
