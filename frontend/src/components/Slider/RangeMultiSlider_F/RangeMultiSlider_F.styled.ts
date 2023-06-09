import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 290px;
  height: 3vh;

  @media (max-width: 1200px) {
    max-width: 200px;
  }
  @media (max-width: 1000px) {
    max-width: 300px;
    width: 300px;
    margin: 20px auto;
  }
`;

const Thumb = styled.input`
  &[type='range'] {
    -webkit-appearance: none;
    -webkit-tap-highlight-color: transparent;
    pointer-events: none;
    position: absolute;
    height: 0;
    width: 290px;
    margin: 0;
    outline: none;

    @media (max-width: 1200px) {
      max-width: 200px;
    }

    @media (max-width: 1000px) {
      max-width: 300px;
      width: 300px;
    }
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
    height: 10px;
    width: 10px;
    margin-top: 6px;
    pointer-events: all;
    position: relative;
  }

  &::-moz-range-thumb {
    background-color: #bb2649;
    border: none;
    border-radius: 50%;
    box-shadow: 0 0 1px 1px #ffffff;
    cursor: pointer;
    height: 10px;
    width: 10px;
    margin-top: 6px;
    pointer-events: all;
    position: relative;
  }
`;

const thumb_zIndex3 = css`
  z-index: 3;
`;
const thumb_zIndex4 = css`
  z-index: 4;
`;
const thumb_zIndex5 = (minVal: number, max: number) => css`
  z-index: (minVal > max - 100) && 5;
`;

const Slider = styled.div`
  position: relative;
  width: 100%;
`;

const Slider_sub = styled.div`
  position: absolute;

  &:nth-of-type(1) {
    background-color: #d9d9d9;
    // border: 1px solid #000000;
    width: 100%;
    height: 5px;
    z-index: 1;
  }
  &:nth-of-type(2) {
    background-color: #bb2649;
    width: 100%;
    height: 5px;
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
  thumb_zIndex3,
  thumb_zIndex4,
  thumb_zIndex5,
  Slider,
  Slider_sub,
  slider_sub12,
  slider_sub34,
};
