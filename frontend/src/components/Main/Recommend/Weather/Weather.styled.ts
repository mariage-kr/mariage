import styled from '@emotion/styled';

const Container = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  width: 20%;
`;

const WeatherWrap = styled.div`
  display: flex;
  width: 100%;
`;

const Temperature = styled.p`
  margin: auto;
  font-size: 2rem;
  font-weight: 600;
  text-align: center;
`;

export { Container, WeatherWrap, Temperature };
