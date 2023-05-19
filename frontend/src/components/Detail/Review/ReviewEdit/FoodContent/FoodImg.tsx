import { useRef } from 'react';
import useImage from 'hooks/useImage';
import * as S from './FoodImg.styled';

function FoodImg() {
  const {
    value: image,
    setValue: setImage,
    preview,
  } = useImage<File | null>(null);

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
        onChange={setImage}
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
