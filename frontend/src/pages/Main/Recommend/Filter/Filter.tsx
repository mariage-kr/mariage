import { useState } from 'react';

import * as S from './Filter.styled';

function Filter() {
  // TODO: 추후 데이터 받아오기
  const [weather, setWeather] = useState('맑은날');

  const [select, setSelect] = useState({
    weather: true,
    recommend: false,
    week: false,
    month: false,
    total: false,
  });

  const [message, setMessage] = useState(
    '현재 날씨에 인기있는 주류의 리스트입니다.',
  );

  const changeSelect = (key: string) => {
    setSelect(prev => {
      return {
        ...Object.fromEntries(
          Object.entries(prev).map(([k, v]) => [k, k === key]),
        ),
      } as {
        weather: boolean;
        recommend: boolean;
        week: boolean;
        month: boolean;
        total: boolean;
      };
    });

    if (key === 'weather') {
      setMessage(`${weather}에 인기있는 주류의 리스트입니다.`);
    } else if (key === 'recommend') {
      setMessage('추천하는 주류의 리스트입니다.');
    } else if (key === 'week') {
      setMessage('지난 1주일간 가장 많이 팔린 주류의 리스트입니다.');
    } else if (key === 'month') {
      setMessage('지난 1달간 가장 많이 팔린 주류의 리스트입니다.');
    } else if (key === 'total') {
      setMessage('전체 기간 동안 가장 많이 팔린 주류의 리스트입니다.');
    }
  };

  return (
    <S.Container>
      <S.Header>인기 주류</S.Header>
      {window.sessionStorage.getItem('isLogin') === 'true' && (
        <S.Button
          select={select.recommend}
          onClick={() => changeSelect('recommend')}
        >
          ✨ 추천
        </S.Button>
      )}
      <S.Button select={select.weather} onClick={() => changeSelect('weather')}>
        🌈 날씨
      </S.Button>
      <S.Button select={select.week} onClick={() => changeSelect('week')}>
        🌒 1주
      </S.Button>
      <S.Button select={select.month} onClick={() => changeSelect('month')}>
        🌓 1달
      </S.Button>
      <S.Button select={select.total} onClick={() => changeSelect('total')}>
        🌕 전체
      </S.Button>
      <S.Message>{message}</S.Message>
    </S.Container>
  );
}

export default Filter;
