import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
`;

const Header = styled.h1`
  color: black;
`;

const Form = styled.form`
  border: 1px solid #0f0f0f50;

  padding: 30px;
  border-radius: 10px;
  box-shadow: 2px 2px 2px #0f0f0f25;

  display: flex;
  align-items: start;
  justify-content: center;
  flex-direction: column;

  width: 460px;
`;

const Input = styled.input`
  width: 460px;
  height: 42px;

  margin-bottom: 20px;

  border: 0;
  border-bottom: 2px solid;

  font-size: 16px;

  transition: 100ms;

  &:focus {
    border-bottom: 2px solid #9c94d0;
    border-radius: 5px;
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
  font-size: 14px;
`;

const ErrorMessage = styled.span`
  display: flex;
  align-items: center;
  justify-content: center;

  height: 40px;
  width: 460px;

  border-radius: 3px;
  background-color: #9c94d050;

  color: #bb2649;
  font-size: 0.9rem;

  margin-bottom: 30px;
`;

export {
  Container,
  StyledLink,
  Header,
  Form,
  Input,
  Label,
  Button,
  ErrorMessage,
};
