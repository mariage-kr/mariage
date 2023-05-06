import styled from '@emotion/styled';

const Container = styled.div`
  height: auto;
  margin: 0 auto;
  padding: 7vh 0 10vh;
`;

const Top = styled.div`
  /* width: 78%; */
  height: 20vh;
  margin: 0 auto;
`;

const TopLeft = styled.div`
  /* width: 80%; */
  overflow: hidden;
  float: left;
`;

const Title = styled.h3`
  margin: 0 0 1.5vh;
  /* padding-left: 0.2vw; */
  font-size: 1.5vw;
`;

const Filter = styled.div`
  height: auto;
`;

const ButtonWrapper = styled.div`
  overflow: hidden;
`;

const Button = styled.button`
  border: 1px solid #9c94d0;
  border-radius: 3vw;
  box-shadow: 0px 0px 5px #b9b9b9;
  background-color: white;
  height: 35px;
  /* height: 2vw; */
  width: 72px;
  /* width: 4.5vw; */
  font-size: 1vw;
  display: inline-block;
  margin-right: 1vw;
  &:focus {
    background-color: #9c94d0;
    color: #fff;
  }
`;

const InfoMessageWrapper = styled.div`
  width: 100%;
`;

const InfoMessage = styled.p`
  margin-top: 1vh;
  padding-left: 0.5vw;
  font-size: 0.8vw;
  letter-spacing: 0.05em;
`;

const TopRight = styled.div`
  border: 1px solid #b9b9b9;
  width: 10%;
  height: 12vh;
  float: right;
`;

export {
  Container,
  Top,
  TopLeft,
  Title,
  Filter,
  ButtonWrapper,
  Button,
  InfoMessageWrapper,
  InfoMessage,
  TopRight,
};
