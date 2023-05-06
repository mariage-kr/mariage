import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  /* border: 1px solid green; */
  width: 80%;
  height: auto;
  margin: 0 auto;
  padding: 7vh 0 20vh;
`;

const Wrapper = styled.div`
  border: 2px solid #9C94D0;
  border-radius: 1.5vw;
  box-shadow: 0px 0px 5px #b9b9b9;
  width: 80%;
  height: auto;
  margin: 0 auto;
  padding: 5vh 0 4.5vh;
`;

const Inner = styled.div`
  /* border: 1px solid green; */
  overflow: hidden;
`;

const Left = styled.div`
  border-right: 1px solid #9C94D0;
  box-sizing: border-box;
  width: 50%;
  height: 23vh;
  margin: 0 auto;
  float: left;
`;

const Drinks = styled.p`
  width: 100%;
  height: auto;
  margin: 0 auto;
`;

const FilterTitle = styled.p`
  height: 100%;
  margin: 0 auto;
  text-align: center;
  font-size: 1vw;
`;

const Right = styled.div`
  border-left: 1px solid #9C94D0;
  box-sizing: border-box;
  width: 50%;
  height: 23vh;
  margin: 0 auto;
  float: right;
`;

const StarRate = styled.div`
  width: 25vw;
  height: auto;
  margin: 0 auto 2.5vh;
  position: relative;
`;

const ABV = styled.div`
  width: 25vw;
  height: auto;
  margin: 0 auto;
  position: relative;
`;

const FilterTitle2 = css`
  position: absolute;
  top: 0;
  left: 50%;
`;

const RangeMultiSlider = styled.div`
  box-sizing: border-box;
  margin: 0 auto;
  padding-top: 1vh;
`;

const Bottom = styled.div`
  box-sizing: border-box;
  margin: 2.5vh auto 0;
  text-align: center;
`;

const FindButton = styled.button`
  border-radius: 0.3vw;
  box-sizing: border-box;
  box-shadow: 0px 0px 5px #b9b9b9;
  background-color: #9C94D0;
  width: 7vw;
  height: 5vh;
  font-size: 1vw;
  color: #fff;
`;


export {
  Container,
  Wrapper,
  Inner,
  Left,
  Drinks,
  FilterTitle,
  FilterTitle2,
  Right,
  StarRate,
  ABV,
  RangeMultiSlider,
  Bottom,
  FindButton
};