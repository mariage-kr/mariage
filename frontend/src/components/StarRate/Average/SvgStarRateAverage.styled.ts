import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  flex-direction: row;

  width: 100px;
  height: 20px;

  border: 1px solid red;
`;

const Image = css`
  width: 20px;
  height: 20px;
`;

export { Container, Image };
