import styled from '@emotion/styled';

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

const Nav = styled.div`
  /* border: 1px solid blue; */

  display: flex;
  align-items: center;
  justify-content: space-around;

  width: 15%;
`;

const Search = styled.div`
  /* border: 1px solid pink; */

  display: flex;
  align-items: center;
  justify-content: center;

  width: 30%;
`;

const Input = styled.input``;

const Profile = styled.div`
  /* border: 1px solid sandybrown; */

  display: flex;
  align-items: center;
  justify-content: space-around;

  width: 20%;
`;

export { Container, Logo, Nav, Search, Input, Profile };
