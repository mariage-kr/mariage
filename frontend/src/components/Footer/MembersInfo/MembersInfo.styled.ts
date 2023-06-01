import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  /* border-top: 1px solid #00000033;
  height: 100px;
  padding: 0 10%;
  overflow: hidden; */
`;

const Member = styled.div`
  width: 10%;
  float: right;
  margin: 0 auto;
  font-size: 1rem;
  text-align: center;
  margin-top: 25px;
  box-sizing: border-box;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  height: 100%;
  width: 10%;
  min-width: 100px;
`;

export { Container, Member, StyledLink };
