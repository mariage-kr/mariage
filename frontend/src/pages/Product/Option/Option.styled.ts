import styled from '@emotion/styled';

const Container = styled.div`
  position: absolute;
  top: 0;
  right: 5%;
  width: 15%;
`;

const Btn = styled.button`
  position: relative;
  font-size: 1rem;
  background-color: transparent;

  &:hover,
  :focus {
    font-weight: bold;
  }

  &::before {
    position: absolute;
    content: '';
    top: 5px;
    left: 0;
    width: 3px;
    height: 15px;
    background-color: #9c94d0;
    opacity: 0;
  }

  &:hover::before,
  :focus::before {
    opacity: 1;
  }
`;

export { Container, Btn };
