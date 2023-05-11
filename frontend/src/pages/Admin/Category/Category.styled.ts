import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  flex-direction: row;
  width: 500px;
`;

const Select = styled.select`
  width: 100px;
  height: 30px;
`;

const Wrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Text = styled.p`
  width: 150px;
  font-size: 1.1rem;
`;

export { Container, Select, Wrapper, Text };
