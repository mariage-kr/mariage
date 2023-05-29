import { axios } from '@/apis/axios';
import { useState, useEffect } from 'react';

import * as S from './Weather.styled';
import {
  Sunny,
  Rain,
  Snow,
  ThunderStorm,
  Clouds,
  Etc,
} from '@/components/Animation/Weather';

interface WeatherData {
  weather: string;
  name: string;
  temp: number;
}

function Weather() {
  const [weatherData, setWeatherData] = useState<WeatherData | null>(null);

  useEffect(() => {
    const fetchWeatherData = () => {
      axios
        .get('/api/weather/info')
        .then(response => {
          setWeatherData({ ...response.data });
        })
        .catch(error => {
          console.error('날씨 정보를 가져올 수 없습니다.', error);
        });
    };

    fetchWeatherData();
  }, []);

  const getWeatherComponent = (weather: string) => {
    const lowerCaseWeather = weather.toLowerCase();

    switch (lowerCaseWeather) {
      case 'clear':
        return <Sunny />;
      case 'rain':
        return <Rain />;
      case 'drizzle':
        return <Rain />;
      case 'snow':
        return <Snow />;
      case 'thunderstorm':
        return <ThunderStorm />;
      case 'clouds':
        return <Clouds />;
      default:
        return <Etc />;
    }
  };

  return (
    <S.Container>
      <S.WeatherWrap>
        {weatherData && (
          <>
            {getWeatherComponent(weatherData.weather)}
            <S.TextWrap>
              <S.Temperature>{weatherData.temp} °</S.Temperature>
              <S.Name>{weatherData.name} </S.Name>
            </S.TextWrap>
          </>
        )}
      </S.WeatherWrap>
    </S.Container>
  );
}

export default Weather;
