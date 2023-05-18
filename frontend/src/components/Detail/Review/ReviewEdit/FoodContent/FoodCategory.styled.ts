import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  overflow: hidden;
  width: 99%;
  height: 100%;
  border: 1px solid #9c94d044;
  border-radius: 10px;
  box-shadow: 0 0 3px #9c94d088;
  margin: 5px;
`;

const Wrapper = styled.div`
  width: 98%;
  margin: 10px 0;
`;

const FoodRadioBtn = styled.label`
  width: 23.5%;
  height: 40px;
  margin: 0;
  padding: 0;
  border-radius: 10px;
  display: inline-block;
  overflow: hidden;

  &:nth-of-type(1) {
    margin-right: 2%;
  }
  &:nth-of-type(2) {
    margin-right: 2%;
  }
  &:nth-of-type(3) {
    margin-right: 2%;
  }
  &:nth-of-type(5) {
    margin-right: 2%;
  }
  &:nth-of-type(6) {
    margin-right: 2%;
  }
  &:nth-of-type(7) {
    margin-right: 2%;
  }
  &:nth-of-type(9) {
    margin-right: 2%;
  }
  &:nth-of-type(10) {
    margin-right: 2%;
  }
  &:nth-of-type(11) {
    margin-right: 2%;
  }
  &:nth-of-type(13) {
    margin-right: 2%;
  }
  &:nth-of-type(14) {
    margin-right: 2%;
  }
  &:nth-of-type(15) {
    margin-right: 2%;
  }
  &:nth-of-type(17) {
    margin-right: 2%;
  }
  &:nth-of-type(18) {
    margin-right: 2%;
  }
  &:nth-of-type(19) {
    margin-right: 2%;
  }
`;

const BtnLabel = styled.label`
  width: 100%;
  height: 100%;
  margin: 0;
  display: flex;
  align-items: top;
`;

const Btn = styled.input`
  visibility: hidden;
  margin: 0;
  padding: 0;

  &:checked + p {
    background-color: #9c94d0;
    color: #fff;
  }
`;

const Label = styled.p`
  display: block;
  border-bottom: 1px solid #eae7e7;
  border-radius: 10px;
  margin: 0;
  padding: 0;
  text-align: center;
  width: 100%;
  height: 100%;
  overflow: hidden;
`;

const ImgText = styled.div`
  display: inline-block;
  vertical-align: middle;
`;

const btnImg = css`
  width: 25px;
  height: 25px;
  object-fit: cover;
  margin: 7px 7px 0 0;
`;

const Img = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const btnText = css`
  font-size: 1rem;
  margin-top: 8px;
`;

export {
  Container,
  Wrapper,
  FoodRadioBtn,
  BtnLabel,
  Btn,
  Label,
  ImgText,
  btnImg,
  Img,
  btnText,
};
