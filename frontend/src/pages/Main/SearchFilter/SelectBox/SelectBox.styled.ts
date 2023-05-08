import styled from '@emotion/styled';

const Container = styled.div`
  /* border: 1px solid orange; */
  width: 100%;
  text-align: center;
  margin-top: 3vh;
`;

const SelectBox = styled.select`
  border: 1px solid #9C94D0;
  border-radius: 0.3vw;
  box-sizing: border-box;
  box-shadow: 0px 0px 5px #b9b9b9;
  background: url('https://i.esdrop.com/d/f/CeyD9bnnT5/1Kum5nNwU4.png') no-repeat 97% 50%; 
  background-size: 15% auto;
  width: 30%;
  height: 5vh;
  margin: 0 1vw;
  padding-left: 0.5vw;
  font-size: 0.9vw;
  &:hover,
  &:focus { 
    outline: none;
    border: 2px solid #9C94D0;
    background-color: rgba(156. 148, 208, 0.5);
  }
  &:disabled {
      opacity: 0.5;
      pointer-events: none;
  }
  &::-ms-expand { display: none; }
  -webkit-appearance: none; 
  -moz-appearance: none;
  appearance: none; 
`;

const Option = styled.option`
  padding: 6px 8px;
  transition: background-color 0.2s ease-in;
  &:hover {
    background-color: rgba(156. 148, 208, 0.5);
  }
`;


export {
  Container,
  SelectBox,
  Option
};