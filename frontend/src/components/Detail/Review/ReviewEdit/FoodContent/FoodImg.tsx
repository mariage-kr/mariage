import { ChangeEventHandler, useRef } from 'react';

import * as S from './FoodImg.styled';

type PropsType = {
  onChange: ChangeEventHandler<HTMLInputElement>;
  preview: string | undefined;
};

function FoodImg({ onChange, preview }: PropsType) {
  const imageInput = useRef<HTMLInputElement>(null);

  // 버튼 클릭시 input태그에 클릭이벤트 적용
  const onClickBtn = () => {
    imageInput.current!.click();
  };

  return (
    <S.Container>
      <S.InputImg
        type={'file'}
        accept={'image/*'}
        onChange={onChange}
        ref={imageInput}
      />
      <S.BtnWrapper>
        <S.InputImgBtn onClick={onClickBtn}>리뷰 사진 업로드</S.InputImgBtn>
      </S.BtnWrapper>
      <S.ImgWrapper>
        <S.PreviewImg src={preview} />
      </S.ImgWrapper>
    </S.Container>
  );
}

export default FoodImg;
