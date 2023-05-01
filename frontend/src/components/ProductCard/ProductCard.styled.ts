import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  border: 1px solid olive;
  border-radius: 1.5vw;
  width: 12.5vw;
  height: 30vh;
  margin: 0 auto;
  overflow: hidden;
`;

const Inner = styled.div`
  // float: left;
  border: 1px solid red;
  overflow: hidden;
`;

const inner_left = css`
  float: left;
  width: 40%;
  height: 24vh;
`;

const img = css`
  border: 1px solid orenge;
  width:200px;
  object-fit: cover;
`;

const inner_right = css`
  float: right;
  width: 58%;
  height: 24vh;
`;

const StarRating = styled.div`
  border: 1px solid blue;
  width: 100%;
  height: 7vh;
  margin: 8vh auto 0.5vh;
  display: flex;
  justify-content: center;
`;

const Review = styled.p`
  width: 100%;
  margin: 5px 0;
  text-align: center;
`;

const Country = styled.div`
  border: 1px solid green;
  width: 100%;
`;

const country_left = css`
  float: left;
  width: 30%;
`;
const flagimg = css`
  border: 1px solid orange;
  width: 100%;
  object-fit: cover;
  text-align: right;
`;

const country_right = css`
  float: right;
  width: 67%;
`;

const Bottom = styled.div`
  border: 1px solid yellow;
  margin: 0 auto;
  padding-top: 0.5vh;
  text-align: center;
  overflow: hidden;
`;


export {
  Container,
  Inner,
  inner_left,
  img,
  inner_right,
  StarRating,
  Review,
  Country,
  country_left,
  flagimg,
  country_right,
  Bottom
}