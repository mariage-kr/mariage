import styled from '@emotion/styled';

const Container = styled.div`
  width: 160px;
  overflow: hidden;
`;

const StarRateText = styled.div`
  float: left;
  text-align: right;
  width: 25%;
  margin: 0;
`;

const Text = styled.span`
  color: #BB2649;
`;

const StarRate = styled.div`
  float: right;
  text-align: right;
  width: 65%;
  margin: 3px 0 0 10%;
`;

export {
  Container,
  StarRate,
  StarRateText,
  Text
};