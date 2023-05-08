import { css } from '@emotion/react';
import styled from '@emotion/styled';

const Container = styled.div``;

const Nav = styled.div`
  border: 1px solid blue;

  display: flex;
  align-items: center;
  /* justify-content: space-around; */
`;

const DropBtn = styled.button`
  font-size: 18px;
  border: none;
  outline: none;
  color: black;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
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

const Dropdown = styled.div`
  float: left;
  overflow: hidden;

  &:hover div {
    display: block;
  }
`;

const DropContent = styled.div`
  display: none;
  position: absolute;
  z-index: 999;

  min-width: 160px;

  background-color: #f9f9f9;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);

  border: 1px solid #00000050;
  border-radius: 5px;
`;

const DropList = styled.p`
  float: none;
  color: black;

  padding: 12px 16px;
  margin: 0px;

  display: block;
  text-align: left;

  transition: 150ms;

  &:hover {
    background-color: #9c94d0;

    font-weight: bold;
    color: #f8f8f8;

    border-radius: 3.5px;
  }
`;

export { Container, Nav, UnderBar, Dropdown, DropBtn, DropContent, DropList };
