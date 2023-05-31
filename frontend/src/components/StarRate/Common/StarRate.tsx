import StarRating from './StarRating';

import * as S from './StarRate.styled';

type PropsType = {
  onChange: (rate: number) => void;
  rate: number | null;
};

const StarRate = ({ onChange, rate }: PropsType) => {
  return (
    <S.Container>
      {rate !== null &&
        <S.StarRateText>
          <S.Text>{rate}</S.Text>점
        </S.StarRateText>
      }
      <S.StarRate>
        <StarRating
          count={5}
          value={rate !== null ? rate : 0}
          edit={true}
          onChange={value => onChange(value)}
        />
      </S.StarRate>
    </S.Container>
  );
};

export default StarRate;
