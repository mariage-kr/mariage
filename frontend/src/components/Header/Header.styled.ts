import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  display: flex;
  justify-content: center;

  height: 100px;

  border-bottom: 1px solid #00000033;
`;

const Logo = styled.div`
  display: flex;
  align-items: center;

  width: 10%;

  min-width: 144px;
`;

const Header = styled.h1`
  color: black;
`;

const Nav = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-evenly;

  width: 15%;

  min-width: 192px;
`;

const Profile = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;

  width: 15%;

  min-width: 144px;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;

  width: auto;
  min-width: 100px;

  text-align: end;
`;

export { Container, Logo, Header, Nav, Profile, StyledLink };
