import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  align-items: center;
  width: 100%;
  min-width: 192px;
`;

const Input = styled.input`
  width: 100%;
  height: 42px;
  border: 0;
  border-bottom: 2px solid #00000050;
  font-size: 16px;
  transition: 100ms;

  &:focus {
    outline: none;
    border-bottom: 3px solid #9c94d0;
  }

  &::placeholder {
    font-size: 1rem;
  }
`;

export { Container, Input };
