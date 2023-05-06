import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  /* border: 1px solid black; */
  display: flex;
  justify-content: center;

  height: 100px;
`;

const Logo = styled.div`
  /* border: 1px solid red; */

  display: flex;
  align-items: center;

  width: 10%;

  min-width: 144px;
`;

const Header = styled.h1`
  color: black;
`;

const Nav = styled.div`
  /* border: 1px solid blue; */

  display: flex;
  align-items: center;
  justify-content: space-evenly;

  width: 15%;

  min-width: 192px;
`;

const Profile = styled.div`
  /* border: 1px solid sandybrown; */

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
