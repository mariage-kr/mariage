import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  margin: 0 auto;
`;

const Wrapper = styled.div`
  border-bottom: 1.5px solid #9C94D044;
  width: 95%;
  height: 100%;
  margin: 0 auto;
  padding: 30px 0 20px;
  overflow: hidden;
`;

const Top = styled.div`
  overflow: hidden;
`;

const TopLeft = styled.div`
  box-sizing: border-box;
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
`;

const ProfileImg = styled.img`
  border-radius: 100%;
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const Profile2 = css`
  width: 70%;
  overflow: hidden;
  padding-bottom: 10px;
`;

const Name = styled.p`
  margin: 0;
  font-size: 1.2rem;
`;

const RateDate = styled.div`
  box-sizing: border-box;
  width: auto;
  display: inline-block;
  vertical-align: bottom;
`;

const Date = styled.p`
  margin: 0 20px;
  padding-bottom: 4px;
  font-size: 1.1rem;
  color: #b7b7b7;
`;


const TopRight = styled.div`
  box-sizing: border-box;
  width: 30%;
  float: right;
  overflow: hidden;
`;

const BtnWrap = styled.div`
  box-sizing: border-box;
  width: 72%;
  float: left;
  text-align: right;
`;

const Btn = styled.button`
  display: inline-block;
  margin: 15px 0 0 3px;
  background-color: #fff;
  color: #090909;
  font-size: 1rem;

  &:hover {
    transform: scale(1.05); 
    text-shadow: 0 0 10px #9C94D099;
    color: #000;
  }
`;

const updateBtn = css`
`;

const deleteBtn = css`
`;

const Like = styled.div`
  box-sizing: border-box;
  width: 28%;
  float: right;
  text-align: right;
`;

const Bottom = styled.div`
  overflow: hidden;
`;

const Food = styled.div`
  box-sizing: border-box;
  float: left;
  width: 10.5%;
  margin: 20px 20px 0 0;
  text-align: center;
`;

const FoodImg = styled.img`
  width: 50%;
  height: 50%;
  object-fit: cover;
`;

const FoodName = styled.p`
  font-size: 1rem;
  margin: 0 auto;
`;

const ReviewRateText = styled.p`
  margin: 5px 0;
  font-size: 0.7rem;
`;

const ReviewRate = styled.span`
  color: #bb2649;
  font-weight: bold;
`;

const Content = styled.div`
  box-sizing: border-box;
  float: right;
  width: 87.6%;
  overflow: hidden;
`;

const ReviewText = styled.div`
  width: 75%;
  font-size: 1rem;
  float: left;
  padding-top: 20px;
`;

const ReviewImg = styled.div`
  border: 1px solid #9C94D044;
  width: 17%;
  text-align: center;
  padding: 10px 0 5px;
  float: right;
`;

const Img = styled.img`
  width: 90%;
  height: 90%;
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
  Bottom,
  Food,
  FoodImg,
  FoodName,
  ReviewRateText,
  ReviewRate,
  Content,
  ReviewText,
  ReviewImg,
  Img,
};