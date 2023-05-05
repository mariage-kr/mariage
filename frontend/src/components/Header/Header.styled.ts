import styled from '@emotion/styled';

const Container = styled.div`
  border: 1px solid black;

  display: flex;
  justify-content: center;

  width: 100%;
  height: 100px;
  min-width: 1000px;
`;

const Logo = styled.div`
  border: 1px solid red;

  display: flex;
  align-items: center;

  width: 15%;
`;

const Nav = styled.div`
  border: 1px solid blue;

  display: flex;
  align-items: center;
  justify-content: space-around;

  width: 15%;
`;

const Search = styled.div`
  border: 1px solid pink;

  display: flex;
  align-items: center;
  justify-content: center;

  width: 30%;
`;

const Profile = styled.div`
  border: 1px solid sandybrown;

  display: flex;
  align-items: center;
  justify-content: space-around;

  width: 20%;
`;

export { Container, Logo, Nav, Search, Profile };
