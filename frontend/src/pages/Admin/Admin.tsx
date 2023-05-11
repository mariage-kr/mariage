import { useEffect, useState } from 'react';

import useInput from '@/hooks/useInput';

import * as S from './Admin.styled';
import { useRef } from 'react';

function Admin() {
  const [isValid, setIsValid] = useState<boolean>(false);
  const [errorMessage, setErrorMessage] = useState<string>('');

  const { value: name, setValue: setName } = useInput<string>('');
  const { value: upperCategory, setValue: setUpperLevel } =
    useInput<string>('');
  const { value: lowerCategory, setValue: setLowerCategory } =
    useInput<string>('');
  const { value: info, setValue: setInfo } = useInput<number>(0);
  const [level, setLevel] = useState<number>(0);

  return (
    <S.Container>
      <S.Header>제품 관리 페이지</S.Header>
      <S.Form onSubmit={() => console.log('run')}>
        {isValid && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Label>제품 이름</S.Label>
        <S.Input type={'text'} value={name} onChange={setName}></S.Input>
        <S.Label>알코올 도수</S.Label>
        <S.Input type={'number'} value={level}></S.Input>
        <S.Label>제품 설명</S.Label>
        <S.TextArea onChange={setInfo}></S.TextArea>
        <S.Count>글자 수 : 0</S.Count>
        <S.Label>국가</S.Label>
        <S.Label>상위 카테고리</S.Label>
        <S.Label>하위 카테고리</S.Label>
        <S.Label>이미지</S.Label>
        <S.Button type={'submit'}>등록하기</S.Button>
      </S.Form>
    </S.Container>
  );
}

export default Admin;
