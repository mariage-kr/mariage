import styled from '@emotion/styled';

const Container = styled.div`
  width: 100%;
  margin: 0;
  padding: 0;
`;

const InputHashTag = styled.input`
  width: 99%;
  height: 40px;
  margin: 10px 0.5% 0;
  padding: 5px;
  border: none;
  border-radius: 10px;
  background-color: #9C94D044;
  box-sizing: border-box;
  box-shadow: 0 0 3px #9C94D088;
  font-size: small;
  cursor: pointer;

  &:hover,
  &:focus {
    box-shadow: 0 0 5px #9C94D0;
    outline: none;
  }

  &::placeholder {
    color: #999999;
  }
`;


export {
  Container,
  InputHashTag,
};