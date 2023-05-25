import { useState, useEffect } from 'react';

import useAuth from '@/hooks/useAuth';
import useBoolean from '@/hooks/useBoolean';

import * as S from './Filter.styled';

type PropsType = {
  changeOption: (option: string) => void;
};

function Filter({ changeOption }: PropsType) {
  const { value: weather, setValue: setWeather } = useBoolean(false);
  const { value: recommend, setValue: setRecommend } = useBoolean(false);
  const { value: week, setValue: setWeek } = useBoolean(false);
  const { value: month, setValue: setMonth } = useBoolean(false);
  const { value: total, setValue: setTotal } = useBoolean(false);

  const [message, setMessage] = useState<string>('');

  const { isLogin } = useAuth();

  useEffect(() => {
    if (isLogin()) {
      setRecommend(true);
      setWeather(false);
      setMessage('회원님에게 추천하는 주류의 리스트입니다.');
      changeOption('algo');
    } else {
      setRecommend(false);
      setWeather(true);
      setMessage('현재 날씨에 인기있는 주류의 리스트입니다.');
      changeOption('weather');
    }
  }, []);

  const changeSelect = (key: string) => {
    setWeather(false);
    setRecommend(false);
    setWeek(false);
    setMonth(false);
    setTotal(false);

    switch (key) {
      case 'weather':
        setWeather(true);
        setMessage('현재 날씨에 인기있는 주류의 리스트입니다.');
        changeOption('weather');
        break;
      case 'recommend':
        setRecommend(true);
        setMessage('회원님에게 추천하는 주류의 리스트입니다.');
        changeOption('algo');
        break;
      case 'week':
        setWeek(true);
        setMessage('지난 1주일간 가장 많이 팔린 주류의 리스트입니다.');
        changeOption('week');
        break;
      case 'month':
        setMonth(true);
        setMessage('지난 1달간 가장 많이 팔린 주류의 리스트입니다.');
        changeOption('month');
        break;
      case 'total':
        setTotal(true);
        setMessage('전체 기간 동안 가장 많이 팔린 주류의 리스트입니다.');
        changeOption('total');
        break;
    }
  };

  return (
    <S.Container>
      <S.Header>인기 주류</S.Header>
      {isLogin() && (
        <S.Button select={recommend} onClick={() => changeSelect('recommend')}>
          ✨ 추천
        </S.Button>
      )}
      <S.Button select={weather} onClick={() => changeSelect('weather')}>
        🌈 날씨
      </S.Button>
      <S.Button select={week} onClick={() => changeSelect('week')}>
        🌒 1주
      </S.Button>
      <S.Button select={month} onClick={() => changeSelect('month')}>
        🌓 1달
      </S.Button>
      <S.Button select={total} onClick={() => changeSelect('total')}>
        🌕 전체
      </S.Button>
      <S.Message>{message}</S.Message>
    </S.Container>
  );
}

export default Filter;
