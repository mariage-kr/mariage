import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;

  margin: 10vh 0;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: gray;
  font-size: 0.9rem;
`;

const Header = styled.h1`
  color: black;
`;

const Form = styled.form`
  display: flex;
  align-items: start;
  justify-content: center;
  flex-direction: column;

  width: 460px;

  padding: 30px;
  border: 1px solid #0f0f0f50;
  border-radius: 10px;
  box-shadow: 2px 2px 2px #0f0f0f25;
`;

const Input = styled.input`
  width: 460px;
  height: 42px;

  margin-bottom: 20px;

  border: 0;
  border-bottom: 3px solid #00000050;

  font-size: 16px;

  transition: 100ms;

  &:focus {
    outline: none;
    border-bottom: 3px solid #bb2649;
  }
`;

const Button = styled.button`
  font-size: 20px;

  width: 460px;
  height: 52px;

  background-color: #9c94d0;
  color: #f8f8f8;
`;

const LinkButton = styled.button`
  font-size: 20px;

  width: 460px;
  height: 52px;

  color: #9c94d0;
  border: 1px solid #9c94d0;
  background-color: #ffffff;
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

const Line = styled.div`
  margin: 20px;
  height: 1px;
  width: 460px;
  background-color: #00000050;
`;

export {
  Container,
  StyledLink,
  Header,
  Form,
  Input,
  Label,
  Button,
  LinkButton,
  ErrorMessage,
  Line,
};
