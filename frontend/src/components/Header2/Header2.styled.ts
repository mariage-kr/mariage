import styled from '@emotion/styled';
import { css } from '@emotion/react';

const styledLink = css`
  width: 30px;
  margin-right: 10px;
  text-decoration: none;
  color: inherit;

  &:hover {
    font-weight: bold;
  }
`;

const Block = styled.div`
  width: 10vw;
`;

const Container = styled.div`
  display: flex;
  align-items: center;
  width: 100%;
  margin: 0 auto;
  height: 100px;
  text-align: center;
  border-bottom: 1px solid #ddd;
`;

const Logo = styled.h1`
  width: 10vw;
`;

const Member = styled.div`
  width: 10%;
`;

export { styledLink, Container, Block, Logo, Member };
