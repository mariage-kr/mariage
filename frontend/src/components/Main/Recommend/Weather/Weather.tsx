import { axios } from '@/apis/axios';
import { useState, useEffect } from 'react';

import * as S from './Weather.styled';
import {
  Sunny,
  Rain,
  Snow,
  ThunderStorm,
  Cloudy,
  SandDust,
} from '@/components/Animation/Weather';

interface WeatherData {
  condition: string;
  temperature: number;
}

const weatherComponents = [
  { condition: 'sunny', components: Sunny },
  { condition: 'rain', components: Rain },
  { condition: 'snow', components: Snow },
  { condition: 'thunderStorm', components: ThunderStorm },
  { condition: 'cloudy', components: Cloudy },
  { condition: 'sandDust', components: SandDust },
];

function Weather() {
  const [weatherData, setWeatherData] = useState<WeatherData | null>(null);

  useEffect(() => {
    const fetchWeatherData = async () => {
      try {
        const response = await axios.get('/api/weather/info');
        setWeatherData(response.data);
      } catch (error) {
        console.error('날씨 데이터를 가져올 수 없습니다.', error);
      }
    };

    fetchWeatherData();
  }, []);

  return (
    <S.Container>
      <S.WeatherWrap>
        {weatherData && (
          <>
            {weatherData.condition === 'sunny' && <Sunny />}
            {weatherData.condition === 'rain' && <Rain />}
            {weatherData.condition === 'snow' && <Snow />}
            {weatherData.condition === 'thunderStorm' && <ThunderStorm />}
            {weatherData.condition === 'cloudy' && <Cloudy />}
            {weatherData.condition === 'sandDust' && <SandDust />}
            <S.Temperature>{weatherData.temperature} °C</S.Temperature>
          </>
        )}
        {/* <Sunny/>
        <S.Temperature>맑음</S.Temperature> */}
      </S.WeatherWrap>
    </S.Container>
  );
}

export default Weather;
