import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`;

const Header = styled.h1`
  color: black;
`;

const CategoryWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  width: 500px;
`;

const Input = styled.input`
  width: 200px;
  height: 25px;
`;

const Select = styled.select`
  width: 210px;
  height: 35px;
`;

const Wrapper = styled.div`
  display: flex;
  align-items: center;

  flex-direction: row;

  width: 750px;
`;

const Label = styled.p`
  width: 150px;
`;

const Text = styled.p`
  width: 200px;
  font-size: 0.9rem;
  margin-left: 50px;
`;

const TextArea = styled.textarea`
  width: 380px;
  height: 100px;
`;

export {
  Container,
  Header,
  CategoryWrapper,
  Input,
  Select,
  Wrapper,
  Label,
  Text,
  TextArea,
};
