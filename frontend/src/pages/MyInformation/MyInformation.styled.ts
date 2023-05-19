import styled from '@emotion/styled';
import { css } from '@emotion/react';

const LinkStyle = css`
  position: relative;
  display: inline-block;
  width: auto;
  margin-right: 30px;
  padding: 20px 0;
  text-decoration: none;
  color: inherit;
  transition: all 0.2s;

  &:hover,
  :focus {
    font-weight: bold;
    text-shadow: 0 0 20px #9c94d033;
  }

  &::after {
    position: absolute;
    content: '';
    bottom: 15px;
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

const ActiveTab = css`
  position: relative;
  display: inline-block;
  width: auto;
  margin-right: 30px;
  padding: 20px 0;
  text-decoration: none;
  color: inherit;
  transition: all 0.2s;

  &:hover,
  :focus {
    font-weight: bold;
    text-shadow: 0 0 20px #9c94d033;
  }

  &::after {
    position: absolute;
    content: '';
    bottom: 15px;
    left: 0px;
    width: 100%;
    height: 3px;
    background-color: #9c94d0;
    opacity: 0;
    transition: transform 0.3s ease;
    transform: scale(0);
  }

  &:focus::after {
    opacity: 1;
    transform: scale(1);
  }
`;

const Nav = styled.ul`
  width: 80%;
  margin: 0;
  padding: 0 10%;
  border-bottom: 1px solid #ddd;
`;


export { LinkStyle, ActiveTab, Nav };
