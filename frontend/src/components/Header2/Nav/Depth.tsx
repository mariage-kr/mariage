import * as S from './Depth.styled';
import { Link } from 'react-router-dom';

type AlcoholCategory = {
  name: string;
  link: string;
};

const kAlcohol: AlcoholCategory[] = [
  { name: '소주', link: '/' },
  { name: '맥주', link: '/' },
  { name: '전통주', link: '/' },
  { name: '기타', link: '/' },
];

const gAlcohol: AlcoholCategory[] = [
  { name: '증류주', link: '/' },
  { name: '맥주', link: '/' },
  { name: '와인', link: '/' },
  { name: '위스키', link: '/' },
  { name: '기타', link: '/' },
];

interface DepthProps {
  showKAlcohol: boolean;
  showGAlcohol: boolean;
}

function Depth({ showKAlcohol, showGAlcohol }: DepthProps) {
  return (
    <>
      <S.AlcoholBlock>
        {showKAlcohol &&
          kAlcohol.map(category => (
            <S.Alcohol key={category.name}>
              <Link to={category.link} css={[S.styledLink, S.UnderBar]}>
                {category.name}
              </Link>
            </S.Alcohol>
          ))}
      </S.AlcoholBlock>
      <S.AlcoholBlock>
        {showGAlcohol &&
          gAlcohol.map(category => (
            <S.Alcohol key={category.name}>
              <Link to={category.link} css={[S.styledLink, S.UnderBar]}>
                {category.name}
              </Link>
            </S.Alcohol>
          ))}
      </S.AlcoholBlock>
    </>
  );
}

export default Depth;
