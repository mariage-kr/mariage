import styled from '@emotion/styled';
import { css } from '@emotion/react';
import './Nav2.styled';

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

const AlcoholBlock = styled.ul`
  display: flex;
  width: 100%;
  margin: 0 auto;
  padding: 0;
  list-style: none;
  background-color: #fff;
  box-shadow: 0px 5px 10px #ddd;
  /* opacity: 0; */
`;

const Alcohol = styled.li`
  width: 5%;
  margin: 0;
  padding: 10px 0;
  text-align: center;
`;

export { styledLink, UnderBar, AlcoholBlock, Alcohol };
