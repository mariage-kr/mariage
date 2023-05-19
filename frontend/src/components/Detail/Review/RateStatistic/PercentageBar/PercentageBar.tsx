import * as S from './PercentageBar.styled';

interface PercentageProps {
  percentage: number;
}

function PercentageBar({ percentage }: PercentageProps) {
  return (
    <S.BarWrapper>
      <S.Bar percentage={percentage} />
    </S.BarWrapper>
  );
}

export default PercentageBar;
