import * as S from './ReviewImage.styled';

type PropsType = {
  imgUrl: string;
  onChange: Function;
  hashtags: string[];
};

function ReviewImage({ imgUrl, onChange, hashtags }: PropsType) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.Img src={imgUrl} />
        <S.InfoWrapper>
          {hashtags.map((hashtag: string, index: number) => {
            return <S.Hashtag key={index}>#{hashtag}</S.Hashtag>;
          })}
        </S.InfoWrapper>
      </S.Wrapper>
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

export default ReviewImage;
