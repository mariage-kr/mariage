import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  /* border: 1px solid sandybrown; */

  display: flex;
  align-items: center;
  justify-content: flex-end;

  width: 25%;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;

  width: auto;
  min-width: 100px;

  text-align: end;
`;

const TextButton = styled.p`
  width: auto;
  min-width: 100px;

  text-align: end;

  cursor: pointer;
`;

export { Container, StyledLink, TextButton };
