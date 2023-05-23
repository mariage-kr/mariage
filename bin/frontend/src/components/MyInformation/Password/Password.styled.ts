import styled from '@emotion/styled';

type InfoMessageProps = {
  isValid?: boolean;
};

const Container = styled.div`
  width: 40.625rem;
  margin: 50px auto;
  padding: 50px 0;
`;

const Label = styled.p`
  margin: 5px auto;
  font-size: 14px;
`;

const Input = styled.input`
  width: 100%;
  height: 40px;
  margin: 0 auto;
  padding: 5px;
  border: 1px solid;
  border-radius: 10px;
  font-size: 1.1rem;
`;

const InfoMessage = styled.span<InfoMessageProps>`
  color: #bb2649;
  visibility: ${({ isValid }) => (isValid ? 'none' : 'hidden')};
  font-size: 0.7rem;
  margin-bottom: 15px;
`;

const Btn = styled.button`
  display: block;
  width: 150px;
  margin: 20px auto;
  padding: 10px;
  border-radius: 10px;
  text-align: center;
  font-size: 1rem;
  background: #9c94d0;
  color: #fff;
`;

export { Container, Label, Input, InfoMessage, Btn };
