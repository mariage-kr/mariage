import styled from '@emotion/styled';

const Container = styled.div`
  overflow: hidden;
  width: 99%;
  height: 257px;
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
  float: left;
  width: 35%;
  margin: 15px 0 0 2.5%;
  padding: 5px 2px;
  box-sizing: border-box;
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
  float: right;
  width: 57.5%;
  height: 215px;
  margin: 20px 2.7% 0 0;
  padding: 15px 0;
  text-align: center;
  border: 1px solid #9C94D022;
  border-radius: 10px;
  box-shadow: 0 0 3px #9C94D044;
  box-sizing: border-box;
`;

const PreviewImg = styled.img`
  width: 45%;
`;


export {
  Container,
  InputImg,
  BtnWrapper,
  InputImgBtn,
  ImgWrapper,
  PreviewImg
};