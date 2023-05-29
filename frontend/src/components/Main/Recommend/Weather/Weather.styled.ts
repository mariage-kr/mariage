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

const TextWrap = styled.div`
  padding: 0 20px;
  box-sizing: border-box;
`;

const Temperature = styled.p`
  width: 120px;
  margin: 10px 0;
  font-size: 2rem;
  font-weight: 600;
`;

const Name = styled.p`
  font-size: 1.1rem;
  font-weight: 600;
`;

export { Container, WeatherWrap, TextWrap, Temperature, Name };
