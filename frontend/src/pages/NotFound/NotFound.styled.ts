import styled from '@emotion/styled';

const Container = styled.div`
  position: relative;
`;

const Text = styled.div`
  display: flex;
  justify-content: center;
  align-items: center; 
  font-size: 40px;
  color: #bb2649;
  margin-bottom: 20px;
`;

const ButtonText = styled.span`
  padding-left: 5px;
`;

const MessageContainer = styled.div`
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -10%);
  z-index: 1;
  margin: 30px 0 10px 0;
  font-size: 20px;
`;

const Message = styled.div`
  font-size: 16px;
`;

const ButtonStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center; 
`;

const Button = styled.button`
  display: flex;
  align-items: center;
  background: none;
  border-style: none;
  padding: 10px 30px;
  color: #bb2649;
`;

const LottieContainer = styled.div`
  top: 10%;
`;

export { Container, Text, Message, MessageContainer, ButtonStyle, ButtonText, Button, LottieContainer };
