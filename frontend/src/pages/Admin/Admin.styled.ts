import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

interface Props {
  isValid: boolean;
}

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;

  margin: 10px 10% 50px;
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

const InputImgContainer = styled.div`
  width: 460px;
  height: auto;
  position: relative;
`;

const InputImgWrap = styled.div`
  width: 460px;
  height: 42px;
  margin-bottom: 20px;
  border: 0;
  border-bottom: 3px solid #00000050;
  font-size: 16px;
  transition: 100ms;
  

  &:focus-within {
    border-bottom: 3px solid #bb2649;
  }
`;

const InputImg = styled.input`
  display: none;
`;

const InputImgBtn = styled.button`
  width: 120px;
  height: 36px;
  padding: 5px 0;
  border-radius: 3px;
  border: 1px solid #000;
  background: #fff;
  font-size: 1rem;

  &:hover {
    background: #000;
    color: #fff;
  }

  &:focus {
    background: #000;
    color: #fff;
  }
`;

const DeleteUploadImgBtn = styled.div`
  font-size: 1.1rem;
  color: #bb2649;
  margin-bottom: 20px;
  cursor: pointer;
  position: absolute;
  top: 5px;
  right: 0;

  &:hover {
    font-weight: bold;
  }
`;

const Button = styled.button<Props>`
  font-size: 20px;

  width: 460px;
  height: 52px;

  background-color: ${props => (props.isValid ? '#9c94d0' : '#f8f8f8')};
  color: ${props => (props.isValid ? '#f8f8f8' : '#000000')};
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

const TextArea = styled.textarea`
  height: 125px;
  width: 460px;
  resize: none;

  border: 1px solid #000;

  &:focus {
    outline: none;
    border: 1px solid #bb2649;
  }
`;

const Count = styled.p`
  margin-top: 5px;
  font-size: 14px;
  color: gray;
`;

const Select = styled.select`
  height: 30px;
  width: 465px;

  margin-bottom: 20px;
`;

const Info = styled.p`
  font-size: 0.8rem;

  color: #00000066;
  margin-top: -15px;
`;

const Image = styled.img`
  margin: 5px 0 20px 0;

  max-width: 460px;
  height: auto;
`;

export {
  Container,
  StyledLink,
  Header,
  Form,
  Input,
  InputImgContainer,
  InputImgWrap,
  InputImg,
  InputImgBtn,
  DeleteUploadImgBtn,
  Label,
  Button,
  LinkButton,
  ErrorMessage,
  Line,
  TextArea,
  Count,
  Select,
  Info,
  Image,
};
