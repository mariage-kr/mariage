import styled from '@emotion/styled';

type InfoMessageProps = {
  isValid?: boolean;
};

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;

  margin: 50px 10%;
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
    border-bottom: 3px solid #9c94d0;
  }
`;

const Button = styled.button`
  font-size: 20px;

  width: 460px;
  height: 52px;

  background-color: #9c94d0;
  color: #f8f8f8;
`;

const DisableButton = styled.button`
  font-size: 20px;

  width: 460px;
  height: 52px;

  background-color: #ffffff;
  border: 1px solid #9c94d0;
  color: #9c94d0;
`;

const Label = styled.label`
  display: block;
  margin-bottom: 5px;
  font-size: 14px;
`;

const InfoMessage = styled.span<InfoMessageProps>`
  color: #bb2649;
  visibility: ${({ isValid }) => (isValid ? 'none' : 'hidden')};
  font-size: 0.7rem;
  margin-bottom: 15px;
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
  Header,
  Form,
  Input,
  Label,
  Button,
  DisableButton,
  InfoMessage,
  ErrorMessage,
};
