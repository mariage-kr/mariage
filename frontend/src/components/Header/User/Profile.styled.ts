import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
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

  &:hover {
    font-weight: bold;
  }
`;

const TextButton = styled.p`
  width: auto;
  min-width: 100px;
  text-align: end;
  cursor: pointer;
`;

export { Container, StyledLink, TextButton };
