import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  /* border: 1px solid olive; */
  box-sizing: border-box;
  width: 520px;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;

  @media (max-width:1920px) { width: 450px; }
  @media (max-width:1550px) { width: 350px; }
  @media (max-width:1200px) { width: 420px; }
`;

const Thumb = styled.input`
  &[type='range'] {
    -webkit-appearance: none;
    -webkit-tap-highlight-color: transparent;
    pointer-events: none;
    position: absolute;
    height: 0;
    width: 450px;
    outline: none;

    @media (max-width:1920px) { width: 380px; }
    @media (max-width:1550px) { width: 280px; }
    @media (max-width:1200px) { width: 350px; }
  }

  &[type='range']::-webkit-slider-thumb {
    -webkit-appearance: none;
    -webkit-tap-highlight-color: transparent;
  }

  &::-webkit-slider-thumb {
    background-color: #bb2649;
    border: none;
    border-radius: 50%;
    box-shadow: 0 0 1px 1px #ffffff;
    cursor: pointer;
    height: 5px;
    width: 5px;
    margin-top: 34.5px;
    pointer-events: all;
    position: relative;
  }

  &::-moz-range-thumb {
    background-color: #bb2649;
    border: none;
    border-radius: 50%;
    box-shadow: 0 0 1px 1px #ffffff;
    cursor: pointer;
    height: 5px;
    width: 5px;
    margin-top: 34.5px;
    pointer-events: all;
    position: relative;
  }
`;

const thumb_zindex3 = css`
  z-index: 3;
`;
const thumb_zindex4 = css`
  z-index: 4;
`;
const thumb_zindex5 = (minVal: number, max: number) => css`
  z-index: (minVal > max - 100) && 5;
`;

const Slider = styled.div`
  // border: 1px solid blue;
  position: relative;
  width: 450px;
  height: 100%;

  @media (max-width:1920px) { width: 380px; }
  @media (max-width:1550px) { width: 280px; }
  @media (max-width:1200px) { width: 350px; }
`;

const Slider_sub = styled.div`
  position: absolute;

  &:nth-of-type(1) {
    background-color: #d9d9d9;
    width: 100%;
    z-index: 1;
  }
  &:nth-of-type(2) {
    background-color: #bb2649;
    z-index: 2;
  }
  &:nth-of-type(3) {
    left: 0;
  }
  &:nth-of-type(4) {
    right: 0;
  }
`;

const slider_sub12 = css`
  border-radius: 3px;
  height: 5px;
  margin-top: 45px;
`;

const slider_sub34 = css`
  color: #000000;
  margin-top: 10px;
  font-size: 1.1rem;
  @media (max-width:1400px) {
    font-size: 1rem;
  }
`;

export {
  Container,
  Thumb,
  thumb_zindex3,
  thumb_zindex4,
  thumb_zindex5,
  Slider,
  Slider_sub,
  slider_sub12,
  slider_sub34,
};
