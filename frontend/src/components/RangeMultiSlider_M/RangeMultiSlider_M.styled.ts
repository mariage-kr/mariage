import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  border: 1px solid olive;
  width: 25vw;
  height: 8vh;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Thumb = styled.input`
  &[type='range'] {
    -webkit-appearance: none;
    -webkit-tap-highlight-color: transparent;
    pointer-events: none;
    position: absolute;
    height: 0;
    width: 21vw;
    outline: none;
  }

  &[type='range']::-webkit-slider-thumb {
    -webkit-appearance: none;
    -webkit-tap-highlight-color: transparent;
  }

  &::-webkit-slider-thumb {
    background-color: #BB2649;
    border: none;
    border-radius: 50%;
    box-shadow: 0 0 1px 1px #ffffff;
    cursor: pointer;
    height: 5px;
    width: 5px;
    margin-top: 2.6vh;
    pointer-events: all;
    position: relative;
  }

  &::-moz-range-thumb {
    background-color: #BB2649;
    border: none;
    border-radius: 50%;
    box-shadow: 0 0 1px 1px #ffffff;
    cursor: pointer;
    height: 5px;
    width: 5px;
    margin-top: 5px;
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
  width: 21vw;
  height: 100%
`;

const Slider_sub = styled.div`
  position: absolute;

  &:nth-of-type(1) {
    background-color: #D9D9D9;
    width: 100%;
    z-index: 1;
  }
  &:nth-of-type(2) {
    background-color: #BB2649;
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
  margin-top: 5vh;
`;

const slider_sub34 = css`
  color: #000000;
  font-size: 1.1rem;
  margin-top:2.2vh;
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
  slider_sub34
}