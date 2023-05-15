import styled from '@emotion/styled';

const Container = styled.div`
  width: 100%;
  margin: 5px 0;
  padding: 0;
`;

const HashTagPrint = styled.div`
  width: auto;
  height: auto;
  margin: 0 5px;
  padding: 5px;
  display: inline-block;
  border-radius: 50px;
  box-shadow: 0 0 3px #b9b9b9;
  background-color: #9c94d0;
  color: #fff;
  font-size: 0.9rem;
`;

const HashTagPrintText = styled.p`
  float: left;
  margin: 0 5px;
`;

const RemoveBtn = styled.p`
  float: right;
  margin: 0;
  padding: 0 1px 0 10px;
  cursor: pointer;
`;

const InputHashTag = styled.input`
  width: 99%;
  height: 40px;
  margin: 5px 0.5% 0;
  padding: 5px 10px;
  border: none;
  border-radius: 10px;
  background-color: #9c94d022;
  box-sizing: border-box;
  box-shadow: 0 0 5px #9c94d066;
  font-size: small;
  color: #000;
  cursor: pointer;

  &:hover,
  &:focus {
    box-shadow: 0 0 5px #9c94d0;
    outline: none;
  }

  &::placeholder {
    color: #999999;
  }
`;

export { Container, HashTagPrint, HashTagPrintText, RemoveBtn, InputHashTag };
