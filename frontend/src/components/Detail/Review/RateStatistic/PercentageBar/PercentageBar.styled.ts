import styled from '@emotion/styled';

interface BarProps {
  percentage: number;
}

const BarWrapper = styled.div`
  width: 100%;
  height: 20px;
  background-color: #9C94D022;

  @media (max-width: 1200px) { height: 15px; }
`;

const Bar = styled.div<BarProps>`
  height: 100%;
  background-color: #9C94D0;
  width: ${props => `${props.percentage}%`};
`;

export { BarWrapper, Bar };
