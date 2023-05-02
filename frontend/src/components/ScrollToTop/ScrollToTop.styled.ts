import styled from '@emotion/styled';

const Container = styled.div`
  position: fixed;
  z-index: 999;

  right: 5%;
  bottom: 5%;
`;

const Button = styled.div`
  border: 1px solid black;
  border-radius: 100%;

  width: 75px;
  height: 75px;

  cursor: pointer;
`;

export { Container, Button };
