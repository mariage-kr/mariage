import React from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../../components/Button/Common/Common';
import Error from '../../components/Error/Error';
import { BROWSER_PATH } from '../../constants/path';
import { ERROR_MESSAGE } from '../../constants/message';
import * as S from './NotFound.styled';


function NotFound() {
  
  const navigate = useNavigate();

  const handleClickReturnButton = () => {
    navigate(BROWSER_PATH.BASE);
    location.reload();
  };

  return (
    <div>
      <S.Container>
      
      <S.Message>
        <S.Text><span>404</span></S.Text>
      <div>{ERROR_MESSAGE.NOTFOUND}</div>
      <S.ButtonStyle>
      <S.Button onClick={handleClickReturnButton}>
        메인으로 돌아가기
      </S.Button>
      </S.ButtonStyle>
      </S.Message>
      
      <S.LottieContainer>
      <Error/>
      </S.LottieContainer>
      </S.Container>
      
    </div>
  );
}

export default NotFound;