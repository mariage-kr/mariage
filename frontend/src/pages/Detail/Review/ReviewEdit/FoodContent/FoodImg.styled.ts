import styled from '@emotion/styled';
import { selector } from 'recoil';

const Container = styled.div`
  overflow: hidden;
  width: 99%;
  height: 300px;
  border: 1px solid #9C94D044;
  border-radius: 10px;
  box-sizing: border-box;
  box-shadow: 0 0 3px #9C94D088;
  margin: 5px;
`;

const InputImg = styled.input`
  border: 1px solid red;
  width: 95%;
  margin: 10px 2.5%;
  padding: 5px 2px;
  display: none;
`;

const BtnWrapper = styled.div`
  width: 95%;
  margin: 15px 2.5% 5px;
  padding: 5px 2px;
`;

const InputImgBtn = styled.button`
  width: 200px;
  height: 40px;
  border-radius: 10px;
  border: 1px solid #9C94D044;
  box-sizing: border-box;
  box-shadow: 0 0 3px #9C94D055;
  background: #fff;
  font-size: 1rem;
  
  &:hover {
    box-shadow: 0 0 5px #9C94D0;
    background: #9C94D0;
    color: #fff;
  }
  &:focus {
    box-shadow: 0 0 5px #9C94D0;
    background: #9C94D0;
    color: #fff;
  }
`;

const ImgWrapper = styled.div`
  width: 95%;
  height: auto;
  margin: 0 auto;
  text-align: center;
`;

const PreviewImg = styled.img`
  width: 30%;
`;


export {
  Container,
  InputImg,
  BtnWrapper,
  InputImgBtn,
  ImgWrapper,
  PreviewImg
};