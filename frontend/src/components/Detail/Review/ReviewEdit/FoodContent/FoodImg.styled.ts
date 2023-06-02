import styled from '@emotion/styled';

const Container = styled.div`
  overflow: hidden;
  width: 99%;
  height: 257px;
  border: 1px solid #9c94d044;
  border-radius: 10px;
  box-sizing: border-box;
  box-shadow: 0 0 3px #9c94d088;
  margin: 5px;
`;

const InputImg = styled.input`
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
`;

const InputImgBtn = styled.button`
  width: 200px;
  height: 42px;
  border-radius: 10px;
  border: 1px solid #9c94d044;
  box-shadow: 0 0 3px #9c94d055;
  background: #fff;
  font-size: 1rem;

  &:hover {
    box-shadow: 0 0 5px #9c94d0;
    background: #9c94d0;
    color: #fff;
  }
  &:focus {
    box-shadow: 0 0 5px #9c94d0;
    background: #9c94d0;
    color: #fff;
  }
`;

const DeleteImgBtn = styled.button`
  width: 200px;
  height: 42px;
  border-radius: 10px;
  border: 1px solid #9c94d044;
  box-shadow: 0 0 3px #9c94d055;
  background: #fff;
  font-size: 1rem;
  margin-top: 20px;

  &:hover {
    box-shadow: 0 0 5px #9c94d0;
    background: #9c94d0;
    color: #fff;
  }
  &:focus {
    box-shadow: 0 0 5px #9c94d0;
    background: #9c94d0;
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
  border: 1px solid #9c94d022;
  border-radius: 10px;
  box-shadow: 0 0 3px #9c94d044;
  box-sizing: border-box;
`;

const PreviewImg = styled.img`
  width: auto;
  height: 185px;
  border-radius: 10px;
`;

export { Container, InputImg, BtnWrapper, InputImgBtn, DeleteImgBtn, ImgWrapper, PreviewImg };
