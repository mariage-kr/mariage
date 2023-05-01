import styled from '@emotion/styled';

type InfoMessageProps = {
  isValid?: boolean;
};

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
  height: 42px;

  margin-bottom: 5px;

  border: 0;
  border-bottom: 1px solid;

  font-size: 16px;
  outline: none;

  &:focus {
    border: 2px solid #9c94d0;
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
  font-size: 1.1rem;

  margin-bottom: 30px;
`;

export {
  Container,
  Header,
  Wrapper,
  Input,
  Label,
  Button,
  InfoMessage,
  ErrorMessage,
};
