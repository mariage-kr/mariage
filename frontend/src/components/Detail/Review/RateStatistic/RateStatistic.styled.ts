import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  padding: 150px 0 0;
`;

const Wrapper = styled.div`
  border: 1px solid #9C94D055;
  width: 85%;
  margin-left: 30px;

  @media (max-width: 980px) { width: 84%; }
`;

const Top = styled.div`
  border-bottom: 1px solid #9C94D055;
  margin: 0 auto;
  padding: 20px 0 15px;
  width: 95%;
  text-align: center;
`;

const AverageRate = styled.div`
  font-size: 1.5rem;
`;

const StarRate = styled.div``;

const TotalRate = styled.div``;

const Span = styled.span`
  color: #bb2649;
`;

const Bottom = styled.div`
  margin: 0 auto;
  padding: 20px 0 25px;
  width: 95%;
  text-align: center;
  font-size: 1rem;

  @media (max-width: 1650px) { font-size: 0.95rem; }
`;

const RateOption = styled.div`
  margin: 0 auto;
  width: 95%;
  text-align: center;
  overflow: hidden;

  @media (max-width: 1400px) { width: 86%; }
`;

const Star = styled.div`
  box-sizing: border-box;
  float: left;
  width: 24%;
  padding-right: 10px;
  margin: 2px 0 0;

  @media (max-width: 1400px) { width: 27%; }
  @media (max-width: 1200px) { width: 31%; }
`;

const StarWrapper = styled.div`
  display: inline-block;
`;

const img = css`
  width: 30px;
  height: 30px;

  @media (max-width: 1800px) { width: 25px; height: 25px; }
  @media (max-width: 1200px) { width: 20px; height: 20px; }
`;

const StarImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const Graph = styled.div`
  float: left;
  width: 58%;

  @media (max-width: 1400px) { width: 70%; }
  @media (max-width: 1200px) { width: 65%; }
`;


const TempGraph = styled.div`
  width: 100%;
  height: 20px;
  margin: 8px 0;

  @media (max-width: 1800px) { margin: 6px 0; }
  @media (max-width: 1200px) { 
    height: 15px;
    margin: 6.5px 0;
  }
`;

const Count = styled.div`
  float: right;
  width: 17%;
  padding-top: 5px;

  @media (max-width: 1800px) { padding-top: 3px; }
  @media (max-width: 1650px) { padding-top: 4.5px; }
  @media (max-width: 1400px) { display: none; }
`;


export {
  Container,
  Wrapper,
  Top,
  AverageRate,
  StarRate,
  TotalRate,
  Span,
  Bottom,
  RateOption,
  Star,
  StarWrapper,
  img,
  StarImg,
  Graph,
  TempGraph,
  Count
};