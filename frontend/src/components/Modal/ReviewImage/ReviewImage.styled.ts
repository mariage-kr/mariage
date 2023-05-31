import styled from '@emotion/styled';

const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 0;
  left: 0;
  overflow: hidden;
  z-index: 1;
`;

const Backdrop = styled.div`
  width: 100%;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 9998;
  background-color: rgba(0, 0, 0, 0.5);
`;

const Wrapper = styled.div`
  z-index: 9999;
  padding: 40px 30px 30px 30px;

  background-color: #f8f8f8;
  border-radius: 5px;
`;

const ImgWrapper = styled.div`
  z-index: 10000;
  width: auto;
  border-radius: 5px;
  box-shadow: 0 0 3px #00000022; 
  box-sizing: border-box;
  padding: 0;
`;

const Img = styled.img`
  width: auto;
  height: auto;
  min-width: 500px;
  max-width: 900px;
  max-height: 65vh;
  object-fit: scale-down;
  object-position: 50% 50%;
  border-radius: 5px;
  text-align: center;
  margin: 0;
  padding-top: 5px;
`;

const InfoWrapper = styled.div`
  z-index: 9999;
  padding: 20px 0;
`;

const Hashtag = styled.p`
  display: inline-block;
  margin: 0 10px 0 0;
  padding: 5px 10px;
  background-color: #9c94d044;
  border-radius: 10px;
`;

export { Container, Wrapper, InfoWrapper,ImgWrapper, Img, Backdrop, Hashtag };
