import React from 'react';
import StarRating from './StarRating';
import * as S from './StarRate.styled';

const StarRate = () => {
  const [rating, setRating] = React.useState(0);

  return (
    <S.Container>
      <S.StarRate>
        <StarRating
          count={5}
          value={rating}
          edit={true}
          onChange={value => setRating(value)}
        />
      </S.StarRate>
      {/* TODO: 페이지에 맞게 스타일 변경 */}
      <S.StarRateText>
        <S.Text>{rating}</S.Text>점
      </S.StarRateText>
    </S.Container>
  );
};

export default StarRate;
