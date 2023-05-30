import { useNavigate } from 'react-router-dom';

import { SORT } from '@/constants/option';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './Option.styled';

type PropsType = {
  minRate: string;
  maxRate: string;
  minLevel: string;
  maxLevel: string;
  sort: string;
  search: string | null;
  upperCategory: string | null;
  lowerCategory: string | null;
};

type OptionSelectType = {
  rate: boolean;
  count: boolean;
};

function Option({
  minRate,
  maxRate,
  minLevel,
  maxLevel,
  search,
  sort,
  upperCategory,
  lowerCategory,
}: PropsType) {
  const navigate = useNavigate();
  const select: OptionSelectType = {
    rate: sort === SORT.FILTER.RATE,
    count: sort === SORT.FILTER.COUNT,
  };

  const findProductsByFilter = (sort: string) => {
    let query = `minRate=${minRate}&maxRate=${maxRate}&minLevel=${minLevel}&maxLevel=${maxLevel}&sort=${sort}`;
    if (upperCategory !== null) {
      query += `&upper=${upperCategory}`;
    }
    if (lowerCategory !== null) {
      query += `&lower=${lowerCategory}`;
    }
    if (search !== null) {
      query += `&search=${search}`;
    }
    navigate(`${BROWSER_PATH.PRODUCT}?${query}`);
    window.location.reload();
  };

  return (
    <S.Container>
      <S.Btn
        onClick={() => findProductsByFilter(SORT.FILTER.RATE)}
        select={select.rate}
      >
        별점순
      </S.Btn>
      <S.Btn
        onClick={() => findProductsByFilter(SORT.FILTER.COUNT)}
        select={select.count}
      >
        리뷰순
      </S.Btn>
    </S.Container>
  );
}

export default Option;
