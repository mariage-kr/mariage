import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  border-top: 1px solid #00000033;
  height: 100px;
  padding: 0 10%;
  overflow: hidden;
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

const Member = styled.p`
  width: 80%;
  float: right;
  margin: 0 auto;
  font-size: 1rem;
  text-align: center;
  margin-top: 25px;
  box-sizing: border-box;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  height: 100%;
  width: 10%;
  min-width: 100px;
`;

export { Container, FLogo, LogoText, Icon, IconImg, Member, StyledLink };
