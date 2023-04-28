import React from 'react';
import { useNavigate } from 'react-router-dom';
import Error from '../../components/Error/Error';
import { BROWSER_PATH } from '../../constants/path';
import { ERROR_MESSAGE } from '../../constants/message';
import * as S from './NotFound.styled';
import { ReactComponent as Back } from '../../assets/svg/back.svg';
import { ReactComponent as Home } from '../../assets/svg/home.svg';

function NotFound() {
  
  const navigate = useNavigate();

  const handleClickHomeButton = () => {
    navigate(BROWSER_PATH.BASE);
    location.reload();
  };

  const handleClickReturnButton = () => {
    navigate(-1);
  };

  return (
    <div>
      <S.Container>
      <S.MessageContainer>
        <S.Text><span>404</span></S.Text>
      <S.Message>{ERROR_MESSAGE.NOTFOUND}</S.Message>
      <S.ButtonStyle>
      <S.Button onClick={handleClickReturnButton}>
        <Back/><S.ButtonText>BACK</S.ButtonText>
      </S.Button>
      <S.Button onClick={handleClickHomeButton}>
        <Home/><S.ButtonText>HOME</S.ButtonText>
      </S.Button>
      </S.ButtonStyle>
      </S.MessageContainer>
      <S.LottieContainer>
      <Error/>
      </S.LottieContainer>
      </S.Container>
    </div>
  );
}

export default NotFound;