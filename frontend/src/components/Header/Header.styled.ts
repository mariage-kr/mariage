import { css } from '@emotion/react';
import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  /* border: 1px solid black; */

  top: 0px;
  left: 0px;

  display: flex;
  justify-content: center;

  width: 100%;
  height: 72px;
  min-width: 1000px;

  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`;

const Logo = styled.div`
  /* border: 1px solid red; */

  display: flex;
  align-items: center;

  width: 15%;
`;

const Header = styled.h1`
  color: black;
`;

const Nav = styled.div`
  /* border: 1px solid blue; */

  display: flex;
  align-items: center;

  width: 15%;
`;

const Search = styled.div`
  /* border: 1px solid pink; */

  display: flex;
  align-items: center;

  width: 30%;
`;

const Input = styled.input`
  width: 70%;
  height: 42px;

  border: 0;
  border-bottom: 2px solid #00000050;

  font-size: 16px;

  transition: 100ms;

  &:focus {
    outline: none;
    border-bottom: 3px solid #bb2649;
  }
`;

const Profile = styled.div`
  /* border: 1px solid sandybrown; */

  display: flex;
  align-items: center;
  justify-content: space-around;

  width: 20%;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
`;

export { Container, Logo, Header, Nav, Search, Input, Profile, StyledLink };
