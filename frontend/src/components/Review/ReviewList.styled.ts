import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  width: 80%;
  height: 280px;
  margin: 0 10% 5vh;
  border: 1px solid #9c94d066;
  border-radius: 10px;
  box-shadow: 3px 3px 3px #9c94d033;

  transition: 250ms;

  &:hover {
    box-shadow: 3px 3px 3px #9c94d0;
  }

  @media (max-width: 1200px) {
    height: 400px;
  }
`;

const Wrapper = styled.div`
  width: 96%;
  height: 240px;
  margin: 20px auto;
  overflow: hidden;

  @media (max-width: 1200px) {
    height: 350px;
    position: relative;
    margin: 20px auto;
  }
`;

const Left = styled.div`
  border-right: 1px solid #9c94d033;
  box-sizing: border-box;
  float: left;
  width: 35%;
  height: 100%;
  padding-right: 2%;
  overflow: hidden;

  cursor: pointer;

  @media (max-width: 1200px) {
    border-right: none;
    float: none;
    width: 100%;
    padding-right: 0;
  }
`;

const ProductLeft = styled.div`
  box-sizing: border-box;
  float: left;
  width: 25%;
  height: 100%;
  text-align: center;

  @media (max-width: 1500px) {
    width: 30%;
  }
  @media (max-width: 1200px) {
    width: 15%;
    height: 300px;
  }
`;

const ProductImg = styled.img`
  width: 70%;
  height: 90%;
  transform: scale(1.2);

  @media (max-width: 1400px) {
    width: 75%;
  }
  @media (max-width: 1300px) {
    width: 80%;
  }
  @media (max-width: 1200px) {
    width: 90%;
    transform: scale(1.3);
  }
`;

const ProductRight = styled.div`
  box-sizing: border-box;
  float: right;
  width: 75%;
  height: 160px;
  font-size: 1rem;
  margin-top: 50px;
  position: relative;

  @media (max-width: 1700px) {
    margin-top: 45px;
  }
  @media (max-width: 1500px) {
    width: 70%;
  }
  @media (max-width: 1300px) {
    margin-top: 40px;
  }
  @media (max-width: 1200px) {
    width: 82%;
    height: 100px;
    margin-top: 20px;
  }
`;

const ProductName = styled.p`
  margin: 0;
  font-weight: bold;
`;

const SubWrap = styled.div`
  position: absolute;
  bottom: 0;
  width: 100%;

  @media (max-width: 1200px) {
    top: 40px;
  }
`;

const CountryWrap = styled.div``;

const Country = styled.div`
  box-sizing: border-box;
  display: inline-block;
  vertical-align: top;
`;

const country_left = css`
  width: 30px;
  height: 30px;
  box-shadow: 1px 1px #9c94d0;
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

const ABV = styled.p`
  margin: 8px 0 0;
  font-size: 1rem;

  @media (max-width: 1650px) {
    margin: 5px 0 0;
  }
`;

const ABVText = styled.span`
  color: #bb2649;
  font-size: 1rem;
`;

const ProductStarRateWrap = styled.div``;

const ProductStarRate = styled.div`
  box-sizing: border-box;
  display: inline-block;
  margin: 5px 0 0;
  padding: 0;
  vertical-align: middle;

  @media (max-width: 1650px) {
    margin: 2px 0 0;
  }
`;

const ProductStarRateText = styled.p`
  margin: 0 10px 0 0;
  font-size: 1.2rem;
  font-weight: bold;
`;

const media1200 = css`
  @media (max-width: 1200px) {
    float: left;
    width: 25%;
  }
  @media (max-width: 1010px) {
    float: left;
    width: 28%;
  }
`;

const Right = styled.div`
  border-left: 1px solid #9c94d033;
  box-sizing: border-box;
  float: right;
  width: 65%;
  height: 100%;
  padding: 1vh 0 0 1.5%;

  @media (max-width: 1200px) {
    border-left: none;
    border-top: 1px solid #9c94d033;
    float: none;
    width: 82%;
    position: absolute;
    top: 125px;
    right: 0;
    padding: 25px 0 0 0;
  }
`;

const ReviewTop = styled.div`
  overflow: hidden;
`;

const ReviewTopLeft = styled.div`
  box-sizing: border-box;
  width: 65%;
  float: left;
  overflow: hidden;
  padding: 0;
`;

const Profile = styled.div`
  display: inline-block;
`;

const Profile1 = css`
  width: 13%;
  margin-right: 3%;

  @media (max-width: 1700px) {
    width: 14%;
  }
  @media (max-width: 1550px) {
    width: 15%;
  }
  @media (max-width: 1450px) {
    width: 16%;
  }
  @media (max-width: 1300px) {
    width: 17%;
  }
`;

const ProfileImg = styled.img`
  border-radius: 100%;
  width: 100%;
  height: 100%;
  object-fit: cover;

  cursor: pointer;
`;

const Profile2 = css`
  width: 70%;
  overflow: hidden;
  padding-bottom: 10px;
`;

const Name = styled.p`
  margin: 0;
  font-size: 1.1rem;

  cursor: pointer;
`;

const RateDate = styled.div`
  box-sizing: border-box;
  width: auto;
  display: inline-block;
  vertical-align: middle;
`;

const Date = styled.p`
  margin: 0 20px;
  font-size: 1.1rem;
  color: #b7b7b7;
`;

const ReviewTopRight = styled.div`
  box-sizing: border-box;
  width: 30%;
  float: right;
  overflow: hidden;
  padding-top: 1vh;

  @media (max-width: 1650px) {
    padding-top: 0.8vh;
  }
`;

const BtnWrap = styled.div`
  /* margin-top: -3px; */

  box-sizing: border-box;
  width: 70%;
  float: left;
  text-align: right;

  @media (max-width: 1750px) {
    width: 65%;
  }
  @media (max-width: 1450px) {
    width: 60%;
  }
  @media (max-width: 1300px) {
    width: 55%;
  }
`;

const Btn = styled.button`
  display: inline-block;
  margin: 20px 0 0 3px;
  background-color: #fff;
  color: #090909;
  font-size: 1rem;

  &:hover {
    transform: scale(1.05);
    text-shadow: 0 0 10px #9c94d099;
    color: #000;
  }

  @media (max-width: 1675px) {
    font-size: 0.9rem;
    margin: 20px 0 0 0;
  }
`;

const updateBtn = css``;

const deleteBtn = css``;

const Like = styled.div`
  box-sizing: border-box;
  width: 30%;
  float: right;
  text-align: right;

  @media (max-width: 1750px) {
    width: 35%;
  }
  @media (max-width: 1675px) {
    transform: scale(0.95);
  }
  @media (max-width: 1450px) {
    width: 40%;
  }
  @media (max-width: 1300px) {
    width: 45%;
    transform: scale(0.9);
  }
`;

const ReviewBottom = styled.div`
  overflow: hidden;
  display: block;
`;

const Food = styled.div`
  box-sizing: border-box;
  float: left;
  width: 11%;
  margin: 20px 0 0 0;
  text-align: center;

  @media (max-width: 1830px) {
    width: 11.5%;
  }
  @media (max-width: 1750px) {
    width: 12%;
  }
  @media (max-width: 1510px) {
    width: 12.5%;
    margin: 10px 0 0 0;
  }
  @media (max-width: 1300px) {
    width: 13%;
  }
  @media (max-width: 1250px) {
    width: 13.5%;
  }
`;

const FoodImg = styled.img`
  width: 50%;
  height: 50%;
  object-fit: cover;
`;

const FoodName = styled.p`
  font-size: 1rem;
  margin: 0 auto;

  @media (max-width: 1675px) {
    font-size: 0.9rem;
  }
  @media (max-width: 1475px) {
    font-size: 0.8rem;
  }
`;

const Content = styled.div`
  box-sizing: border-box;
  float: right;
  width: 86%;
  margin: 0 0.5% 0 0;
  padding: 0;
  overflow-y: auto;
  height: 145px;

  -ms-overflow-style: none; /* 인터넷 익스플로러 */
  scrollbar-width: none; /* 파이어폭스 */

  &::-webkit-scrollbar {
    display: none; /* 크롬, 사파리, 오페라, 엣지 */
  }

  @media (max-width: 1830px) {
    width: 85.5%;
  }
  @media (max-width: 1750px) {
    width: 85%;
  }
  @media (max-width: 1510px) {
    width: 84.5%;
  }
  @media (max-width: 1300px) {
    width: 84%;
  }
  @media (max-width: 1250px) {
    width: 83.5%;
  }
  @media (max-width: 1200px) {
    height: 120px;
  }
`;

const ReviewText = styled.div`
  width: 76%;
  font-size: 1rem;
  float: left;

  @media (max-width: 1830px) {
    width: 76.5%;
  }
  @media (max-width: 1750px) {
    width: 71.5%;
  }
  @media (max-width: 1100px) {
    font-size: 0.9rem;
  }
`;

const ReviewContentText = styled.p`
  width: 100%;
  margin: 10px 0 0 0;

  @media (max-width: 1510px) {
    margin: 5px 0 0 0;
  }
`;

const HashTag = styled.p`
  display: inline-block;
  margin: 15px 10px 0 0;
  padding: 5px 10px;
  background-color: #9c94d022;
  border-radius: 10px;
`;

const ReviewImg = styled.div`
  box-sizing: border-box;
  border: 1px solid #9c94d044;
  width: 22%;
  text-align: center;
  margin-top: 5px;
  padding: 1vh 0 0;
  float: right;

  cursor: pointer;

  @media (max-width: 1750px) {
    width: 27%;
  }
  @media (max-width: 1510px) {
    margin-top: 15px;
  }
  @media (max-width: 1200px) {
    margin-top: 17px;
  }
`;

const Img = styled.img`
  width: 90%;
  height: 90%;
`;

const BtnHeight = css`
  margin-top: 10px;
  @media (max-width: 1750px) {
    margin-top: 10px;
  }
  @media (max-width: 1450px) {
    margin-top: 10px;
  }
  @media (max-width: 1300px) {
    margin-top: 10px;
  }
`;

const ReviewUpdate = styled.div`
  z-index: 1;
  width: 100%;
`;

export {
  Container,
  Wrapper,
  Left,
  ProductLeft,
  ProductImg,
  ProductRight,
  ProductName,
  SubWrap,
  CountryWrap,
  Country,
  country_left,
  FlagImg,
  country_right,
  ABV,
  ABVText,
  ProductStarRateWrap,
  ProductStarRate,
  ProductStarRateText,
  media1200,
  Right,
  ReviewTop,
  ReviewTopLeft,
  Profile,
  Profile1,
  Profile2,
  ProfileImg,
  Name,
  RateDate,
  Date,
  ReviewTopRight,
  BtnWrap,
  Btn,
  updateBtn,
  deleteBtn,
  Like,
  ReviewBottom,
  Food,
  FoodImg,
  FoodName,
  Content,
  ReviewText,
  ReviewContentText,
  HashTag,
  ReviewImg,
  Img,
  BtnHeight,
  ReviewUpdate,
};
