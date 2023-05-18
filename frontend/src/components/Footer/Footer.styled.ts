import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  border-top: 1px solid #00000033;
  display: flex;
  align-items: center;
  height: 100%;
  padding: 0 10%;
  text-align: center;
`;

const FLogo = styled.div`
  width: 100%;
  text-align: left;
  overflow: hidden;
`;

const LogoText = styled.h2`
  width: auto;
  color: #000;
  float: left;
`;

const Icon = styled.div`
  width: 35px;
  height: 35px;
  float: left;
  margin-top: 17px;
  margin-left: -7px;
`;

const IconImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const Member = styled.p`
  width: 80vw;
  margin: 0 auto;
  font-size: 1rem;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  height: 100%;
  width: 10%;
  min-width: 100px;
`;

export { Container, FLogo, LogoText, Icon, IconImg, Member, StyledLink };
