import * as S from './ImageModal.styled';

type PropsType = {
  imgUrl: string;
  onChange: Function;
};

function ImageModal({ imgUrl, onChange }: PropsType) {
  return (
    <S.Container>
      <S.Img src={imgUrl} />
      <S.Backdrop
        onClick={(e: React.MouseEvent) => {
          e.preventDefault();
          if (onChange) {
            onChange();
          }
        }}
      />
    </S.Container>
  );
}

export default ImageModal;
