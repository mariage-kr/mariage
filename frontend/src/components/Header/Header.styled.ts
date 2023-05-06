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

  width: 15%;

  min-width: 144px;
`;

const Header = styled.h1`
  color: black;
`;

const Nav = styled.div`
  /* border: 1px solid blue; */

  display: flex;
  align-items: center;

  width: 20%;

  min-width: 192px;
`;

const Search = styled.div`
  /* border: 1px solid pink; */

  display: flex;
  align-items: center;

  width: 20%;

  min-width: 192px;
`;

const Input = styled.input`
  width: 80%;
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

export { Container, Logo, Header, Nav, Search, Input, Profile, StyledLink };
