import { useRef, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import * as S from './FoodImg.styled';

function FoodImg() {

  const [imageSrc, setImageSrc]: any = useState(null);

  const onUpload = (e: any) => {
      const file = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(file);

      return new Promise<void>((resolve) => { 
          reader.onload = () => {	
              setImageSrc(reader.result || null); // 파일의 컨텐츠
              resolve();
          };
      });
  }

  const imageInput = useRef<any>();
 
  // 버튼클릭시 input태그에 클릭이벤트를 걸어준다. 
  const onClickBtn = () => {
    imageInput.current.click();
  };


  return (
    <S.Container>
      <S.InputImg 
        type='file'
        id='upload'
        multiple
        accept="image/*"
        onChange={e => onUpload(e)}
        ref={imageInput}
      />
      <S.BtnWrapper>
        <S.InputImgBtn onClick={onClickBtn}>리뷰 사진 업로드</S.InputImgBtn>
      </S.BtnWrapper>
      <S.ImgWrapper>
       <S.PreviewImg src={imageSrc} />      
      </S.ImgWrapper>
    </S.Container>
  );
}

export default FoodImg;