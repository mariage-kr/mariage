import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  flex-direction: row;

  width: 120px;
  height: 25px;
  margin: 0 auto;
`;

const Image = css`
  width: 25px;
  height: 25px;
`;

export { Container, Image };
