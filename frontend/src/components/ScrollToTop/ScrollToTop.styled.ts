import styled from '@emotion/styled';

const Container = styled.div`
  position: fixed;
  z-index: 999;
  right: 5%;
  bottom: 5%;
`;

const Button = styled.div`
  border: 1.5px solid #9c94d0;
  border-radius: 100%;
  width: 75px;
  height: 75px;

  cursor: pointer;

  transition: 250ms;
  &:hover {
    background-color: #9c94d066;
  }
`;

export { Container, Button };
