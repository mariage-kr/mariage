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
  padding: 14px 20px;
  background-color: inherit;
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
  left: 0;
  z-index: 999;

  width: 78%;
  margin: 0;
  padding-top: 10px;
  padding-left: 20.3%;

  background-color: #fff;
  box-shadow:  0px 15px 10px -15px rgba(0, 0, 0, 0.2);

  border-top: 0;
  border-radius: 5px;

  cursor: pointer;
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
