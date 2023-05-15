import styled from '@emotion/styled';

const Container = styled.div`
  margin: 0;
  padding: 150px 0 0;
`;

const Wrapper = styled.div`
  box-sizing: border-box;
  border: 1px solid #9C94D055;
  width: 85%;
  margin: 0 0 0 30px;
  padding: 0;

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
  margin: 0;
  font-size: 1.5rem;
`;

const StarRate = styled.div`
  margin: 0;
`;

const TotalRate = styled.div`
  margin: 0;
`;

const Bottom = styled.div`
  margin: 0 auto;
  padding: 15px 0 20px;
  width: 95%;
  text-align: center;
`;

const RateOption = styled.div`
  margin: 0 auto;
  width: 95%;
  text-align: center;
  overflow: hidden;
`;

const Star = styled.div`
  box-sizing: border-box;
  float: left;
  width: 41%;
  padding-right: 3px;
  transform: scaleX(-1);

  @media (max-width: 1640px) { width: 45%; }
  @media (max-width: 1495px) { width: 50%; }
  @media (max-width: 1345px) { 
    width: 68%; 
    text-align: left;
  }
  @media (max-width: 1100px) { width: 72%; }
`;

const Graph = styled.div`
  box-sizing: border-box;
  float: left;
  width: 41%;
  /* padding-right: 3px; */

  @media (max-width: 1640px) { width: 39%; }
  @media (max-width: 1495px) { width: 34%; }
  @media (max-width: 1345px) { display : none; }
`;


const TempGraph = styled.div`
  box-sizing: border-box;
  background-color: lightcyan;
  width: 100%;
  height: 20px;
  margin: 3px 0;
`;

const Count = styled.div`
  box-sizing: border-box;
  float: right;
  width: 18%;

  @media (max-width: 1640px) { width: 16%; }
  @media (max-width: 1495px) { font-size: 0.9rem; }
  @media (max-width: 1345px) { 
    width: 30%;
    text-align : left;
  }
  @media (max-width: 1100px) { width: 25%; }
`;


export {
  Container,
  Wrapper,
  Top,
  AverageRate,
  StarRate,
  TotalRate,
  Bottom,
  RateOption,
  Star,
  Graph,
  TempGraph,
  Count
};