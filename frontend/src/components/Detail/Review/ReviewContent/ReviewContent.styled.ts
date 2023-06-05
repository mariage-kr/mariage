import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  margin: 0 auto;
`;

const Wrapper = styled.div`
  border-bottom: 1.5px solid #9c94d044;
  width: 95%;
  height: 100%;
  margin: 0 auto;
  padding: 30px 0;
  overflow: hidden;
`;

const Top = styled.div`
  overflow: hidden;
`;

const TopLeft = styled.div`
  width: 70%;
  float: left;
  overflow: hidden;
  padding: 0;
`;

const Profile = styled.div`
  display: inline-block;
`;

const Profile1 = css`
  width: 15%;
  margin-right: 20px;

  @media (max-width: 1650px) {
    width: 17%;
    margin-right: 18px;
  }
  @media (max-width: 1400px) {
    width: 19%;
  }
  @media (max-width: 1150px) {
    width: 20%;
  }
  @media (max-width: 1050px) {
    width: 21%;
    margin-right: 15px;
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
  margin-bottom: 20px;

  @media (max-width: 1650px) {
    width: 68%;
    margin-bottom: 18px;
  }
  @media (max-width: 1400px) {
    width: 66%;
    margin-bottom: 17px;
  }
  @media (max-width: 1150px) {
    width: 65%;
    margin-bottom: 15px;
  }
  @media (max-width: 1050px) {
    width: 64%;
    margin-bottom: 13px;
  }
`;

const Name = styled.p`
  margin: 0;
  font-size: 1.2rem;

  cursor: pointer;
`;

const RateDate = styled.div`
  width: auto;
  display: inline-block;
  vertical-align: middle;
`;

const Date = styled.p`
  margin: 0 0 0 20px;
  font-size: 1.1rem;
  color: #b7b7b7;
`;

const TopRight = styled.div`
  width: 30%;
  float: right;
  overflow: hidden;
  padding-top: 40px;

  @media (max-width: 1750px) {
    padding-top: 30px;
  }
  @media (max-width: 1200px) {
    padding-top: 25px;
  }
`;

const BtnWrap = styled.div`
  width: 73%;
  padding: 10px 0;
  float: left;
  text-align: right;

  @media (max-width: 1780px) {
    width: 70%;
  }
  @media (max-width: 1600px) {
    width: 65%;
  }
  @media (max-width: 1370px) {
    width: 60%;
  }
  @media (max-width: 1170px) {
    width: 57%;
  }
`;

const Btn = styled.button`
  display: inline-block;
  background-color: #fff;
  color: #00000070;
  font-size: 1rem;

  &:hover {
    transform: scale(1.05);
    text-shadow: 0 0 10px #9c94d099;
    color: #bb2649;
  }

  @media (max-width: 1100px) {
    font-size: 0.9rem;
  }
`;

const updateBtn = css``;

const deleteBtn = css``;

const Like = styled.div`
  width: 80px;
  float: right;
  text-align: right;

  @media (max-width: 1100px) {
    width: 70px;
  }
`;

const ReviewUpdate = styled.div`
  box-sizing: border-box;
  z-index: 1;
  width: 100%;
  height: 10vh;
`;

const Bottom = styled.div`
  overflow: hidden;
`;

const Food = styled.div`
  float: left;
  width: 10.5%;
  margin: 20px 1vw 0 0;
  text-align: center;

  @media (max-width: 1310px) {
    width: 11%;
  }
  @media (max-width: 1095px) {
    width: 11.5%;
  }
  @media (max-width: 1045px) {
    width: 12%;
  }
  @media (max-width: 1005px) {
    width: 13%;
  }
`;

const FoodName = styled.p`
  font-size: 1rem;
  margin: 0 auto;

  @media (max-width: 1670px) {
    font-size: 0.9rem;
  }
  @media (max-width: 1475px) {
    font-size: 0.8rem;
  }
  @media (max-width: 1250px) {
    font-size: 0.7rem;
  }
`;

const ReviewRateText = styled.p`
  margin: 5px 0;
  font-size: 0.8rem;

  @media (max-width: 1670px) {
    font-size: 0.7rem;
  }
  @media (max-width: 1250px) {
    font-size: 0.6rem;
  }
`;

const ReviewRate = styled.span`
  color: #bb2649;
  font-weight: bold;
`;

const Content = styled.div`
  float: right;
  width: 87.6%;
  overflow: hidden;

  @media (max-width: 1310px) {
    width: 87%;
  }
  @media (max-width: 1095px) {
    width: 86%;
  }
  @media (max-width: 1005px) {
    width: 85%;
  }
`;

const ReviewText = styled.div`
  width: 75%;
  font-size: 1rem;
  float: left;

  @media (max-width: 1750px) {
    width: 70%;
  }
  @media (max-width: 1100px) {
    font-size: 0.9rem;
  }
`;

const ReviewContentText = styled.p`
  width: 100%;
`;

const HashTag = styled.p`
  display: inline-block;
  margin: 0 10px 0 0;
  padding: 5px 10px;
  background-color: #9c94d022;
  border-radius: 10px;
`;

const ReviewImg = styled.div`
  border: 1px solid #9c94d044;
  width: 22%;
  height: 200px;
  text-align: center;
  float: right;

  cursor: pointer;

  @media (max-width: 1750px) {
    width: 27%;
  }
  @media (max-width: 1570px) {
    margin-top: 10px;
  }
  @media (max-width: 1450px) {
    margin-top: 15px;
    height: 180px;
  }
  @media (max-width: 1300px) {
    height: 160px;
  }
  @media (max-width: 1200px) {
    margin-top: 17px;
    height: 150px;
  }
  @media (max-width: 1100px) {
    height: 140px;
  }
  @media (max-width: 1000px) {
    height: 130px;
  }
`;

const Img = styled.img`
  width: 94%;
  height: 94%;
  margin: 3% auto;
  object-fit: cover;
  object-position: 50% 50%;
`;

const SirenIcon = styled.img`
  width: 28px;
  height: 28px;
  object-fit: cover;

  &:hover {
    color: #bb2649;
    background-color: #bb2649;
  }
`;



export {
  Container,
  Wrapper,
  Top,
  TopLeft,
  Profile,
  Profile1,
  Profile2,
  ProfileImg,
  Name,
  RateDate,
  Date,
  TopRight,
  BtnWrap,
  Btn,
  updateBtn,
  deleteBtn,
  Like,
  ReviewUpdate,
  Bottom,
  Food,
  FoodName,
  ReviewRateText,
  ReviewRate,
  Content,
  ReviewText,
  ReviewContentText,
  HashTag,
  ReviewImg,
  Img,
  SirenIcon,
};
