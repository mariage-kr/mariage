import styled from '@emotion/styled';

const Container = styled.div`
  position: relative;
`;

const Text = styled.div`
  display: flex;
  justify-content: center;
  align-items: center; 
  font-size: 4vw;
  color: #bb2649;
  margin-bottom: 1.3889vw;
`;

const ButtonText = styled.span`
  padding-left: 0.3472vw;
`;

const MessageContainer = styled.div`
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -10%);
  z-index: 1;
  margin: 2.0833vh 0 0.6944vh 0;
  font-size: 1.3889vw;
`;

const Message = styled.div`
  font-size: 2vw;
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
  padding: 0.6944vh 2.0833vw;
  color: #bb2649;
`;

const LottieContainer = styled.div`
  top: 10%;
`;

export { Container, Text, Message, MessageContainer, ButtonStyle, ButtonText, Button, LottieContainer };
