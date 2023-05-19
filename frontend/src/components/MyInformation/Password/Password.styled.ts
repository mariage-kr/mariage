import styled from '@emotion/styled';

type InfoMessageProps = {
  isValid?: boolean;
};

const Container = styled.div`
  width: 40%;
  margin: 10vh auto;
`;

const Label = styled.p`
  margin: 20px auto 5px;
  padding-left: 5px;
  font-size: 1rem;
`;

const Input = styled.input`
  width: 100%;
  height: 40px;
  margin: 0 auto;
  padding: 5px;
  border: 1px solid;
  border-radius: 10px;border: 1px solid #9c94d066;
  border-radius: 10px;
  box-shadow: 2px 2px 5px #9c94d055;
  font-size: 1rem;
  color: #000;

  &:placeholder {
    color: #555;
  }

  &:focus {
    outline: none;
    border: 2px solid #9c94d0;
    box-shadow: 2px 2px 5px #9c94d077;
  }

  &:nth-child(1) {
    margin: 0 auto 20px;
  }
`;

const InfoMessage = styled.span<InfoMessageProps>`
  color: #bb2649;
  visibility: ${({ isValid }) => (isValid ? 'none' : 'hidden')};
  font-size: 0.7rem;
  margin: 0 0 0 5px;
`;

const Btn = styled.button`
  display: block;
  width: 150px;
  height: 52px;
  margin: 20px auto;
  border-radius: 10px;
  font-size: 1rem;
  background: #9c94d0;
  color: #fff;

  &:hover {
    font-weight: bold;
    transform: scale(1.05);
  }
`;

export { Container, Label, Input, InfoMessage, Btn };
