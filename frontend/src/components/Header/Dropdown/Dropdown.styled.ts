import { css } from '@emotion/react';
import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div``;

const Dropdown = styled.div`
  float: left;
  overflow: hidden;
  transition: all 0.2s;

  &:hover div {
    display: block;
  }
`;

const DropBtn = styled.button`
  font-size: 18px;
  outline: none;
  color: black;
  padding: 20px;
  background-color: inherit;

  @media (max-width:1160px) { padding: 20px 15px; }
  @media (max-width:1005px) { padding: 20px 13px; font-size: 1rem;}

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

const DropContent = styled.div`
  display: none;
  position: absolute;
  top: 80px;
  left: -10px;
  z-index: 999;

  width: 100%;
  margin: 0;
  padding-top: 10px;
  padding-left: 22.5vw;

  background-color: #fff;
  box-shadow:  0px 15px 10px -15px rgba(0, 0, 0, 0.2);
  border-radius: 5px;
  cursor: pointer;

  @media (max-width:1400px) { padding-left: 24.5vw; }
  @media (max-width:1250px) { padding-left: 25.5vw; }
  @media (max-width:1160px) { padding-left: 26.7vw; }
  @media (max-width:1065px) { padding-left: 28.5vw; }
`;

const DropList = styled.p`
  float: left;
  padding: 12px 16px;
  margin: 10px 0;
  display: block;
  text-align: left;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;

  transition: 150ms;
  &:hover {
    color: #9c94d0;
    font-weight: bold;
  }
`;

export {
  Container,
  UnderBar,
  Dropdown,
  DropBtn,
  DropContent,
  DropList,
  StyledLink,
};
