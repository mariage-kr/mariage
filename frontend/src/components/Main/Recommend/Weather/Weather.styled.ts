import styled from '@emotion/styled';

const Container = styled.div`
  position: absolute;
  top: 20px;
  right: 0;
  width: 20%;
`;

const WeatherWrap = styled.div`
  display: flex;
  width: 100%;
`;

const Temperature = styled.p`
  width: 120px;
  margin: 10px 10px 10px 0px;
  font-size: 2rem;
  font-weight: 600;
  text-align: center;
`;

const Name = styled.p`
  margin: 0 17px;
  font-size: 1.1rem;
  font-weight: 600;
`;

export { Container, WeatherWrap, Temperature, Name };
