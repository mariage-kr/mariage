import {
  Rating000,
  Rating012,
  Rating034,
  Rating055,
  Rating067,
  Rating089,
  Rating100,
} from 'assets/svg/SVG';

import * as S from './SvgStarRateAverage.styled';

type RateType = {
  id: number;
  rate: number;
};

function SvgStarRateAverage({ id, rate }: RateType) {
  const getStar = () => {
    const floorRate = Math.floor(rate);
    const decimalRate = Math.round((rate % 1) * 10);

    let stars: JSX.Element[] = new Array(5);
    for (let i = 0; i < stars.length; i++) {
      if (i < floorRate) {
        stars[i] = <Rating100 key={`${id}_${i}`} css={S.Image} />;
      } else if (i == floorRate) {
        if (decimalRate === 0) {
          stars[i] = <Rating000 key={`${id}_${i}`} css={S.Image} />;
        } else if (decimalRate === 1 || decimalRate === 2) {
          stars[i] = <Rating012 key={`${id}_${i}`} css={S.Image} />;
        } else if (decimalRate === 3 || decimalRate === 4) {
          stars[i] = <Rating034 key={`${id}_${i}`} css={S.Image} />;
        } else if (decimalRate === 5) {
          stars[i] = <Rating055 key={`${id}_${i}`} css={S.Image} />;
        } else if (decimalRate === 6 || decimalRate === 7) {
          stars[i] = <Rating067 key={`${id}_${i}`} css={S.Image} />;
        } else if (decimalRate === 8 || decimalRate === 9) {
          stars[i] = <Rating089 key={`${id}_${i}`} css={S.Image} />;
        }
      } else {
        stars[i] = <Rating000 key={`${id}_${i}`} css={S.Image} />;
      }
    }

    return stars;
  };

  return <S.Container>{getStar()}</S.Container>;
}

export default SvgStarRateAverage;
