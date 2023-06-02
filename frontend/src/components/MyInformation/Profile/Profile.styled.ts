import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  width: 40%;
  margin: 10vh auto;

  @media (max-width: 1550px) {
    width: 45%;
  }
  @media (max-width: 1380px) {
    width: 50%;
  }
  @media (max-width: 1240px) {
    width: 55%;
  }
  @media (max-width: 1130px) {
    width: 60%;
  }
  @media (max-width: 1030px) {
    width: 65%;
  }
`;

const Profile = styled.div`
  width: 100%;
  margin: 0 auto;
  overflow: hidden;
`;

const ProfileImage = styled.div`
  width: 30%;
  float: left;
  text-align: center;
  margin-left: 10%;
  box-sizing: border-box;
`;

const Text = styled.p``;

const ImgWrap = styled.div`
  width: 170px;
  height: 170px;
  margin: 2px auto;
  padding: 7px 5px 3px;
  border-radius: 50%;
  box-shadow: 0 0 5px #9c94d055;
  position: relative;
`;

const Img = styled.img`
  width: 165px;
  height: 165px;
  margin: 0 auto;
  border-radius: 50%;
  background: url(https://i.esdrop.com/d/f/CeyD9bnnT5/K86nd4Er00.png) no-repeat;
  background-size: contain;
  box-sizing: border-box;
`;

const UpdateImg = styled.img`
  width: 165px;
  height: 165px;
  margin: 0 auto;
  border-radius: 50%;
  box-sizing: border-box;
  position: absolute;
  top: 7px;
  left: 5%;
  border: 1px solid red;
  object-fit: scale-down;
`;

const updateImg1 = css`
  background-color: none;
`;
  
const updateImg2 = css`
  background-color: #fff;
`;

const Info = styled.div`
  width: 55%;
  margin-top: 60px;
  float: right;
`;

const Name = styled.p`
  font-size: 1.5rem;
  font-weight: 500;
  margin: 0;
`;

const Email = styled.span`
  font-size: 0.9rem;
  color: #888;
  padding-left: 10px;
`;

const Birth = styled.p`
  color: #888;
  margin: 5px 0;
`;

const ImageInput = styled.input`
  display: none;
`;

const Btn = styled.button`
  width: 320px;
  height: 40px;
  margin: 30px 20px 0 0;
  padding: 5px 10px 6px;
  border: 1px solid #9c94d066;
  border-radius: 15px;
  background-color: #fff;
  box-shadow: 2px 2px 5px #9c94d055;
  font-size: 1rem;

  &:hover,
  &:focus {
    color: #fff;
    background-color: #9c94d0;
    box-shadow: 2px 2px 5px #b9b9b9;
  }
`;

const Btn2 = styled.button`
  display: inline-block;
  width: 150px;
  height: 40px;
  margin: 20px 20px 5px 0;
  padding: 5px 10px 6px;
  border: 1px solid #9c94d066;
  border-radius: 15px;
  background-color: #fff;
  box-shadow: 2px 2px 5px #9c94d055;
  font-size: 1rem;

  &:hover,
  &:focus {
    color: #fff;
    background-color: #9c94d0;
    box-shadow: 2px 2px 5px #b9b9b9;
  }
`;

const deleteBtn = css`
  border: 1px solid #bb264966;
  box-shadow: 2px 2px 5px #bb264955;
  &:hover,
  &:focus {
    color: #fff;
    background-color: #bb2649;
    box-shadow: 2px 2px 5px #b9b9b9;
  }
`;

const NicknameWrap = styled.div`
  width: 90%;
  margin: 10vh 0 0 5%;
  overflow: hidden;

  @media (max-width: 1800px) {
    margin: 10vh 0 0 7%;
  }
  @media (max-width: 1700px) {
    margin: 10vh 0 0 8%;
  }
  @media (max-width: 1600px) {
    margin: 10vh 0 0 9%;
  }
  @media (max-width: 1550px) {
    margin: 10vh 0 0 8%;
  }
  @media (max-width: 1450px) {
    margin: 10vh 0 0 9%;
  }
`;

const Label = styled.p`
  margin: 0 0 0 10px;
  font-size: 1rem;
`;

const Nickname = styled.input`
  width: 70%;
  height: 40px;
  padding: 5px;
  margin: 5px;
  border: 1px solid #9c94d066;
  border-radius: 10px;
  box-shadow: 2px 2px 5px #9c94d055;
  font-size: 1rem;
  color: #000;
  float: left;

  &:placeholder {
    color: #555;
  }

  &:focus {
    outline: none;
    border: 2px solid #9c94d0;
    box-shadow: 2px 2px 5px #9c94d077;
  }

  @media (max-width: 1800px) {
    width: 69%;
  }
`;

const BtnSubmit = styled.button`
  display: block;
  width: 25%;
  height: 52px;
  margin: 5px;
  border-radius: 10px;
  text-align: center;
  font-size: 1rem;
  background: #9c94d0;
  color: #fff;
  float: right;

  &:hover {
    font-weight: bold;
    transform: scale(1.05);
  }
`;



export {
  Container,
  Profile,
  ProfileImage,
  Text,
  ImgWrap,
  Img,
  UpdateImg,
  updateImg1,
  updateImg2,
  Info,
  Name,
  Email,
  Birth,
  Btn,
  Btn2,
  deleteBtn,
  NicknameWrap,
  Label,
  Nickname,
  BtnSubmit,
  ImageInput,
};
