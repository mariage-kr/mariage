import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`;

const Header = styled.h1`
  color: black;
`;

const Wrapper = styled.div`
  display: flex;
  align-items: start;
  justify-content: center;
  flex-direction: column;

  width: 460px;
`;

const Input = styled.input`
  width: 460px;
  height: 26px;

  margin-bottom: 30px;

  border: 0;
  border-bottom: 1px solid;

  font-size: 16px;
  outline: none;

  &:focus {
    border-bottom: 1px solid #9c94d0;
  }
`;

const Button = styled.button`
  font-size: 20px;

  width: 460px;
  height: 52px;

  background-color: #9c94d0;
  color: #f8f8f8;
`;

const Label = styled.label`
  display: block;
  margin-bottom: 5px;
  font-size: 13px;
`;

export { Container, Header, Wrapper, Input, Label, Button };
