import styled from '@emotion/styled';

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
    flex-wrap: wrap;
    justify-content: flex-end;
  }

  @media (max-width: 1000px) {
    padding: 0;
  }
`;

const Image = styled.div`
  width: 13%;
  margin: 0 20px;

  @media (max-width: 1200px) {
    width: 43%;
    margin: 0;
    padding: 0 30px;
    box-sizing: border-box;
  }

  @media (max-width: 1000px) {
    width: 210px;
    margin: 0 auto;
  }
`;

const Img = styled.img`
  width: 100%;
  min-width: 90%;

  @media (max-width: 1200px) {
    width: 70%;
    min-width: 65%;
  }
  @media (max-width: 1000px) {
    width: 100%;
  }
`;

const Content = styled.div`
  width: 60%;
  padding: 20px 0 0 40px;

  @media (max-width: 1200px) {
    width: 50%;
    padding: 0;
  }

  @media (max-width: 1000px) {
    display: flex;
    flex-flow: wrap;
    width: 80%;
    margin: 0 auto;
  }
`;

const CountryWrap = styled.div`
  display: flex;
  width: 30%;
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

  @media (max-width: 1000px) {
    display: none;
  }
`;

const p = styled.p`
  @media (max-width: 1000px) {
    width: 70%;
    margin-left: 10px;
  }
`;

const FoodWrap = styled.ul`
  display: flex;
  padding: 0;

  @media (max-width: 1000px) {
    width: 50%;
  }
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

  @media (max-width: 1200px) {
    display: flex;
    width: 50%;
    margin-right: 7%;
  }

  @media (max-width: 1000px) {
    position: absolute;
    bottom: 2.5%;
    right: 5%;
    display: block;
    width: 50%;
    margin: 0;
  }
`;

const Star = styled.div`
  width: 90%;
  margin: 0 auto;
  text-align: center;

  @media (max-width: 1200px) {
    display: flex;
    width: 60%;
  }

  @media (max-width: 1000px) {
    display: block;
    width: 50%;
  }
`;

const StarRateText = styled.p`
  margin: 5px auto;
  font-size: 1.5rem;
  font-weight: bold;

  @media (max-width: 1200px) {
    margin: 0 auto;
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
};
