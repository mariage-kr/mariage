import styled from '@emotion/styled';

interface BarProps {
  percentage: number;
}

const BarWrapper = styled.div`
  width: 100%;
  height: 16px;
  background-color: rgba(156, 148, 208, 0.2);
`;

const Bar = styled.div<BarProps>`
  height: 100%;
  background-color: #9C94D0;
  width: ${props => `${props.percentage}%`};
`;

const Container = styled.div`
  margin: 0 5px;
`;

export { BarWrapper, Bar, Container };
