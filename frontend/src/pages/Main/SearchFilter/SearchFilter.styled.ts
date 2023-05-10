import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  height: auto;
  margin: 0 auto;
  padding: 5vh 0 10vh;
`;

const Wrapper = styled.div`
  border: 2px solid #9C94D055;
  border-radius: 1.5vw;
  box-shadow: 0px 0px 10px #9c94d044;
  width: 1370px;
  height: auto;
  margin: 0 auto;
  padding: 40px 0 35px;
  overflow: hidden;

  @media (max-width:1919px) { width: 1090px; }
  @media (max-width:1570px) { 
    width: 820px;
    padding: 35px 0 30px; 
  }
  @media (max-width:1200px) {
    width: 530px;
    padding: 40px 0;
  }
`;

const Inner = styled.div`
  /* border: 1px solid green; */
  overflow: hidden;

  @media (min-width:1920px) { 
    border-right: 1px solid #9C94D033;
    box-sizing: border-box;
    float: left;
    width: 77%; 
  }
`;

const Left = styled.div`
  border-right: 1px solid #9C94D033;
  box-sizing: border-box;
  width: 50%;
  height: 200px;
  margin: 0 auto;
  float: left;

  @media (min-width:1920px) { 
    width: 38%;
    
  }
  @media (max-width:1200px) { 
    border-right: none;
    border-bottom: 1px solid #9C94D033;
    width: 80%;
    height: 150px;
    float: none; 
  }
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
  font-size: 1.3rem;

  @media (max-width:1500px) {
    font-size: 1.1rem;
  }
`;

const Right = styled.div`
  border-left: 1px solid #9C94D033;
  box-sizing: border-box;
  width: 50%;
  height: 200px;
  margin: 0 auto;
  float: right;

  @media (min-width:1920px) { 
    width: 62%; 
  }
  @media (max-width:1200px) { 
    border-left: none;
    border-top: 1px solid #9C94D033;
    width: 80%;
    height: 220px;
    padding-top: 20px;
    float: none; 
  }
`;

const StarRate = styled.div`
  box-sizing: border-box;
  width: 520px;
  height: auto;
  margin: 0 auto 25px;
  position: relative;

  @media (max-width:1919px) { width: 450px; }
  @media (max-width:1570px) { width: 350px; }
  @media (max-width:1200px) { width: 420px; }
`;

const ABV = styled.div`
  box-sizing: border-box;
  width: 520px;
  height: auto;
  margin: 0 auto;
  position: relative;

  @media (max-width:1919px) { width: 450px; }
  @media (max-width:1570px) { width: 350px; }
  @media (max-width:1200px) { width: 420px; }
`;

const FilterTitle2 = css`
  position: absolute;
  top: 0;
  left: 46%;
`;

const RangeMultiSlider = styled.div`
  box-sizing: border-box;
  margin: 0 auto;
  padding-top: 5px;
  overflow: hidden;
`;

const Bottom = styled.div`
  box-sizing: border-box;
  margin: 2.5vh auto 0;
  text-align: center;

  @media (min-width:1920px) { 
    border-left: 1px solid #9C94D033;
    float: right;
    width: 23%; 
    height: 200px;
    margin: 0 auto;
    display: flex;
    justify-content: center;
    align-items: center;
  }
`;

const FindButton = styled.button`
  border: 1px solid #9C94D055;
  border-radius: 0.3vw;
  box-sizing: border-box;
  box-shadow: 0px 0px 5px #9C94D0;
  background-color: #fff;
  width: 120px;
  height: 45px;
  font-size: 1.2rem;
  color: #000;
  transition: 250ms;

  &:hover {
    box-shadow: 0px 0px 5px #b9b9b9;
    background-color: #9C94D0;
    color: #fff;
  }

  @media (min-width:1920px) { height: 70px; }
  @media (max-width:1919px) { width: 360px; }
  @media (max-width:1600px) { font-size: 1rem; }
  @media (max-width:1200px) { margin: 30px 0 15px; }
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
  FindButton,
};
