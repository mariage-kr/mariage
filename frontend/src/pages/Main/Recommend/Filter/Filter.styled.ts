import styled from '@emotion/styled';

type Select = {
  select: boolean;
};

const Container = styled.div`
  margin: 50px 0 30px;
`;

const Header = styled.h2`
  color: black;
`;

const Button = styled.button<Select>`
  width: auto;
  min-width: 78px;
  height: 50px;

  margin-right: 15px;
  padding: 0 10px;
  font-size: 1.1rem;

  background-color: ${prop => (prop.select ? '#9c94d0' : '#fff')};
  color: ${prop => (prop.select ? '#f8f8f8' : '#000')};

  box-shadow: 1px 1px 3px ${prop => (prop.select ? '#00000030' : '#00000030')};

  transition: 250ms;

  &:hover {
    box-shadow: 1.5px 1.5px 3px #00000090;
  }
`;

const Message = styled.p`
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
`;

export { Container, Header, Button, Message };
