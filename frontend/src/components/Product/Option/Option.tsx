import { SORT } from '@/constants/option';
import * as S from './Option.styled';

type PropsType = {
  changeSort: (option: string) => void;
};

function Option({ changeSort }: PropsType) {
  const changeOption = (option: string) => {
    changeSort(option);
  };

  return (
    <S.Container>
      <S.Btn type={'button'} onClick={() => changeOption(SORT.FILTER.RATE)!}>
        별점순
      </S.Btn>
      <S.Btn type={'button'} onClick={() => changeOption(SORT.FILTER.COUNT)!}>
        리뷰순
      </S.Btn>
    </S.Container>
  );
}

export default Option;
