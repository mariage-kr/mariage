import { ChangeEventHandler, useRef, useState } from 'react';

import * as S from './FoodImg.styled';

type PropsType = {
  onChange: ChangeEventHandler<HTMLInputElement>;
  preview: string | undefined;
};

function FoodImg({ onChange, preview }: PropsType) {
  const imageInput = useRef<HTMLInputElement>(null);
  const [uploadedImage, setUploadedImage] = useState<File | null>(null);
  const [previewImage, setPreviewImage] = useState<string | undefined>(preview);

  // 업로드 버튼 클릭 이벤트
  const onClickInputImgBtn = () => {
    if (imageInput.current) {
      imageInput.current.click();
    }
  };

  // 삭제 버튼 클릭 이벤트
  const onClickDeleteImgBtn = () => {
    setUploadedImage(null); // 이미지 파일 초기화
    setPreviewImage(undefined); // 프리뷰 이미지 초기화
    onChange({
      target: {
        value: '',
        files: null,
      },
    } as React.ChangeEvent<HTMLInputElement>);
  };

  // 이미지 파일 변경 이벤트
  const onImageChange: ChangeEventHandler<HTMLInputElement> = (event) => {
    const file = event.target.files && event.target.files[0];
    if (file) {
      setUploadedImage(file);
      setPreviewImage(URL.createObjectURL(file)); // 프리뷰 이미지 설정
      onChange(event);
    }
  };

  return (
    <S.Container>
      <S.InputImg
        type={'file'}
        accept={'image/*'}
        onChange={onImageChange}
        ref={imageInput}
      />
      <S.BtnWrapper>
        <S.InputImgBtn onClick={onClickInputImgBtn}>리뷰 사진 업로드</S.InputImgBtn>
        {uploadedImage && (
          <S.DeleteImgBtn onClick={onClickDeleteImgBtn}>리뷰 사진 삭제</S.DeleteImgBtn>
        )}
      </S.BtnWrapper>
      <S.ImgWrapper>
        {previewImage && <S.PreviewImg src={previewImage} />}
      </S.ImgWrapper>
    </S.Container>
  );
}

export default FoodImg;
