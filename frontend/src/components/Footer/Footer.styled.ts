import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  /* border-top: 1px solid #00000033; */
  height: 250px;
  padding: 0 10%;
  overflow: hidden;
  /* #bb2649 */
  background-color: rgba(187, 38, 73, 0.05);
  /* background-color: #dbdeff; */
  /* #9c94d0 */
  /* background-color: rgba(156, 148, 208, 0.2);  */
`;

const FLogo = styled.div`
  width: 20%;
  float: left;
  margin-top: 25px;
  overflow: hidden;
  box-sizing: border-box;
`;

const LogoText = styled.h2`
  width: auto;
  color: #000;
  float: left;
  margin: 4px 0 0;
`;

const Icon = styled.div`
  width: 35px;
  height: 35px;
  float: left;
  margin-left: -7px;
`;

const IconImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  height: 100%;
  width: 10%;
  min-width: 100px;
`;

const ContentWrapper = styled.div`
  width: 80%;
`;

const UserArea = styled.div`
  float: right;
  width: 20%;
  /* margin-top: 150px; */
  box-sizing: border-box;

  @media (max-width: 1385px) {
    width: 30%;
  }
  @media (max-width: 1030px) {
    width: 31%;
  }
  @media (max-width: 1005px) {
    width: 28%;
  }
  @media (max-width: 985px) {
    width: 29%;
  }
`;

const TextContainer = styled.div`
  width: 80%;
  border-top: 1px solid #00000033;
  padding: 0 10%;
  margin-bottom: 0;
  overflow: hidden;
  background-color: rgba(187, 38, 73, 0.05);
`;

const FooterText = styled.div`
  width: 40%;
  float: left;
  margin: 10px 0;
`;

const Mark = styled.img`
  float: right;
  cursor: pointer;
  width: 50px;
  height: 50px;
  margin: 14px 0;
`;

export {
  Container,
  FLogo,
  LogoText,
  Icon,
  IconImg,
  StyledLink,
  FooterText,
  ContentWrapper,
  UserArea,
  TextContainer,
  Mark,
};
