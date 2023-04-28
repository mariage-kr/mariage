import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  border: 1px solid olive;
  width: 20vw;
  height: 5vh;
  padding-top: 3vh;
  display: flex;
  // align-items: center;
  justify-content: center;
`;

const Thumb = styled.input`
  &[type='range'] {
    -webkit-appearance: none;
    -webkit-tap-highlight-color: transparent;
    pointer-events: none;
    position: absolute;
    height: 0;
    width: 17vw;
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
    height: 1.8vh;
    width: 0.7vw;
    margin-top: 1.1vh;
    pointer-events: all;
    position: relative;
  }

  &::-moz-range-thumb {
    background-color: #BB2649;
    border: none;
    border-radius: 50%;
    box-shadow: 0 0 1px 1px #ffffff;
    cursor: pointer;
    height: 1.8vh;
    width: 0.7vw;
    margin-top: 1.1vh;
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
  position: relative;
  width: 17vw;
`;

const Slider_sub = styled.div`
  position: absolute;

  &:nth-of-type(1) {
    background-color: #D9D9D9;
    // border: 1px solid #000000;
    width: 100%;
    height: 1.5vh;
    z-index: 1;
  }
  &:nth-of-type(2) {
    background-color: #BB2649;
    width: 100%;
    height: 1.5vh;
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
  border-radius: 2vw;
  height: 5px;
`;

const slider_sub34 = css`
  color: #000000;
  font-size: 1rem;
  margin-top: 15px;
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