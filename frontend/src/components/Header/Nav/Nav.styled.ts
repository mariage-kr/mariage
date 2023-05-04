import styled from '@emotion/styled';
import { css } from '@emotion/react';

const styledLink = css`
  text-decoration: none;
  color: inherit;
`;

const UnderBar = css`
  position: relative;

  &:hover,
  :focus {
    font-weight: bold;
  }

  &::after {
    position: absolute;
    content: '';
    bottom: -5px;
    left: 0;
    width: 100%;
    height: 3px;
    background-color: #9c94d0;
    opacity: 0;
    transition: transform 0.3s ease;
    transform: scale(0);
  }

  &:hover::after {
    opacity: 1;
    transform: scale(1);
  }
`;

const NavBlock = styled.div`
  width: 100%;
  margin: 0 auto;
  border-bottom: 1px solid #ddd;
`;

const Block = styled.div`
  width: 10vw;
`;

const Category = styled.ul`
  position: relative;
  display: flex;
  width: 20%;
  margin: 5px 0;
  padding: 0;
  text-align: center;
  transition: all 0.2s;
  list-style: none;

  /* &::before:hover,::before:focus{
    position: absolute;
    content: "";
    bottom: -2px;
    left: 0
    width: 150px;
    height: 5px;
    background-color: #9c94d0;
  } */

  /* & :hover,
  :focus {
    font-weight: bold;
    border-bottom: 3px solid #9c94d0;
  } */
`;

const InOut = styled.li`
  width: 30%;
  cursor: pointer;

  & :hover,
  :focus {
    font-weight: bold;
    border-bottom: 3px solid #9c94d0;
  }
`;

const AlcoholBlock = styled.ul`
  display: flex;
  width: 80%;
  margin: 0 auto;
  padding: 0;
  list-style: none;
`;

const Alcohol = styled.li`
  width: 5%;
  margin: 0;
  padding: 10px 0;
  text-align: center;
`;

const Link = styled.a`
  list-style: none;
  text-decoration: none;
`;

export {
  styledLink,
  UnderBar,
  Block,
  NavBlock,
  Category,
  InOut,
  AlcoholBlock,
  Alcohol,
};
