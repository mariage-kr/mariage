import styled from '@emotion/styled';
import { css } from '@emotion/react';
/** @jsxImportSource @emotion/react */

const Inner = css`
  width: 100%;
`;

const NavBlock = styled.div`
  width: 80vw;
  margin: 0 auto;
`;

const Category = styled.ul`
  display: flex;
  width: 10%;
  margin: 0;
  padding: 0;
  text-align: center;
  transition: all 0.2s;
  list-style: none;

  && :hover,
  :focus {
    border-bottom: 3px solid #9c94d0;
    font-weight: bold;
  }
`;

const InOut = styled.li`
  width: 50%;
  cursor: pointer;
  box-sizing: border-box;
`;

const AlcoholBlock = styled.ul`
  display: flex;
  width: 80%;
  margin: 0 auto;
  list-style: none;
`;

const Alcohol = styled.li`
  width: 5%;
  margin: 0;
  padding: 0;
`;

const Link = styled.a`
  list-style: none;
  text-decoration: none;
`;

export { Inner, NavBlock, Category, InOut, AlcoholBlock, Alcohol };
