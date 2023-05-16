import * as S from './PercentageBar.styled';

interface PercentageProps {
    percentage: number;
}

function PercentageBar({ percentage }: PercentageProps) {
    
  return (
    <div>
        <S.Container>
      <S.BarWrapper>
      <S.Bar
        percentage={percentage}
      />
    </S.BarWrapper>
    </S.Container>
    </div>
  );
}

export default PercentageBar;
