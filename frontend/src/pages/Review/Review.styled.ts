import styled from '@emotion/styled';
import { css } from '@emotion/react';

type Props = {
  option?: boolean;
};

const Container = styled.div``;

const TopNav = styled.div`
  border-bottom: 1px solid #9c94d055;
  padding: 0 10%;
`;

const NavWrapper = styled.div`
  width: 100%;
  height: 90%;
  display: flex;
  align-items: flex-end;
`;

const Nav = styled.p<Props>`
  display: inline-block;
  width: auto;
  margin: 0 30px 0 0;
  padding: 20px 0;
  text-decoration: none;
  color: inherit;
  transition: all 0.2s;
  cursor: pointer;

  color: ${props => (props.option ? '#9c94d0' : '#000')};
  font-weight: ${props => (props.option ? 'bold' : 'normal')};
`;

const LinkStyle = css`
  position: relative;

  &:hover,
  :focus {
    font-weight: bold;
    text-shadow: 0 0 20px #9c94d033;
  }

  &::after {
    position: absolute;
    content: '';
    bottom: 15px;
    left: 0;
    width: 100%;
    height: 3px;
    background-color: #9c94d0;
    opacity: 0;
    transition: transform 0.3s ease;
    transform: scale(0);
  }

  &:hover::after {
    opacity: 1;
    transform: scale(1);
  }
`;

const ActiveTab = css`
  position: relative;
  font-weight: bold;
  text-shadow: 0 0 20px #9c94d033;
  
  &::after {
    position: absolute;
    content: '';
    bottom: 15px;
    left: 0px;
    width: 100%;
    height: 3px;
    background-color: #9c94d0;
    opacity: 0;
    transition: transform 0.3s ease;
    transform: scale(0);
  }

  &:focus::after {
    opacity: 1;
    transform: scale(1);
  }
`;

const Main = styled.div`
  margin: 0 10%;
`;

const Profile = styled.div`
  width: 100%;
  margin: 5vh 0 4vh;
  overflow: hidden;
`;

const ProfileLeft = styled.div`
  float: left;
  width: 150px;
  height: 150px;
  margin: 0 0 0 2%;

  @media (max-width: 1700px) {
    width: 140px;
  }
  @media (max-width: 1300px) {
    width: 130px;
  }
`;

const ProfileImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 50%;
  background: url(https://i.esdrop.com/d/f/CeyD9bnnT5/K86nd4Er00.png) no-repeat;
`;

const ProfileRight = styled.div`
  float: right;
  width: 85%;
  padding-top: 30px;

  @media (max-width: 1700px) {
    padding-top: 25px;
  }
  @media (max-width: 1550px) {
    width: 83.5%;
  }
  @media (max-width: 1450px) {
    width: 82.5%;
  }
  @media (max-width: 1350px) {
    width: 81.5%;
  }
  @media (max-width: 1250px) {
    width: 80.7%;
  }
  @media (max-width: 1150px) {
    width: 80%;
  }
  @media (max-width: 1050px) {
    width: 79%;
  }
  @media (max-width: 950px) {
    width: 78%;
  }
`;

const NameEmail = styled.div`
  display: inline-block;
  margin-right: 10px;
`;

const name = css`
  margin: 0 10px 0 0;
  font-size: 1.3rem;
  font-weight: bold;
`;

const email = css`
  font-size: 0.9rem;
  color: #b9b9b9;
`;

const Reviews = styled.div`
  width: 100%;
  overflow: hidden;
  margin-top: 1.5vh;
`;

const Likes = styled.div`
  width: 100%;
  overflow: hidden;
`;

const Title = styled.p`
  float: left;
  width: 80px;
  margin: 0;
  font-size: 1rem;
`;

const Count = styled.p`
  float: right;
  width: 92%;
  margin: 0;
  font-size: 1rem;

  @media (max-width: 1500px) {
    width: 91%;
  }
  @media (max-width: 1350px) {
    width: 90%;
  }
  @media (max-width: 1250px) {
    width: 89%;
  }
  @media (max-width: 1150px) {
    width: 88%;
  }
  @media (max-width: 1050px) {
    width: 87%;
  }
  @media (max-width: 980px) {
    width: 86%;
  }
`;

const Target = styled.div`
  height: 30px;
`;

const AniWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  scale: calc(1);
`;

export {
  Container,
  TopNav,
  NavWrapper,
  Nav,
  LinkStyle, 
  ActiveTab,
  Main,
  Profile,
  ProfileLeft,
  ProfileImg,
  ProfileRight,
  NameEmail,
  name,
  email,
  Reviews,
  Likes,
  Title,
  Count,
  Target,
  AniWrapper,
};
