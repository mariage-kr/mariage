import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div``;

const TopNav = styled.div`
  border-bottom: 1px solid #9c94d055;
  padding: 20px 10%;
`;

const NavWrapper = styled.div`
  width: 100%;
  height: 90%;
  display: flex;
  align-items: flex-end;
`;

const Nav = styled.p`
  display: inline-block;
  margin: 0 30px 0 0;

  cursor: pointer;
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
