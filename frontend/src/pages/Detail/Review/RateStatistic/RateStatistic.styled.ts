import styled from '@emotion/styled';
import { css } from '@emotion/react';


const Container = styled.div`
  margin: 0;
  padding: 150px 0 0;
`;

const Wrapper = styled.div`
  border: 1px solid #9C94D055;
  width: 85%;
  margin: 0 0 0 30px;
  padding: 0;
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
`;

const EditBtn = styled.button`
  border-radius: 5px;
  box-sizing: border-box;
  box-shadow: 1px 1px 3px #00000030;
  background-color: #9C94D0;
  width: 85%;
  height: 50px;
  margin: 30px 0 0 30px;
  padding: 0;
  text-align : center;
  color: #fff;
  transition: 250ms;
  
  &:hover {
    box-shadow: 1.5px 1.5px 3px #9C94D0;
    transform: scale(1.05);
  } 
`;

const Edit = styled.div`
  display: inline-block;
  vertical-align: bottom;
  margin: 0 5px;
  font-size: 1.1rem;
`;

const editi = css`
  width: 25px;
  height: 25px;
`;

const EditIcon = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
  margin: 0 10px 0 0;
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
  Count,
  EditBtn,
  EditIcon,
  editi,
  Edit
};