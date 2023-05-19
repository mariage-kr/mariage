import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  width: 100%;
  position: relative;
`;

const Wrapper = styled.div`
  position: absolute;
  right: 0;
  padding: 0;
`;

const Wrapper2 = styled.div`
  position: absolute;
  right: 0;
  padding: 20px 0 0;
`;

const Wrap = styled.div`
  display: inline-block;
  text-align: right;
  margin-left: 40px;
  box-sizing: border-box;

  @media (max-width:1160px) { margin-left: 30px; }
  @media (max-width:1005px) { margin-left: 26px; }
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  box-sizing: border-box;

  &:hover {
    font-weight: bold;
  }

  @media (max-width:1005px) { font-size: 1rem; }
`;

const TextButton = styled.p`
  cursor: pointer;

  &:hover {
    font-weight: bold;
  }

  @media (max-width:1005px) { font-size: 1rem; }
`;

export { Container, Wrapper, Wrapper2, Wrap, StyledLink, TextButton };
