import Lottie from 'lottie-react';
import sunny from '@/assets/lottie/sunny.json';
import rain from '@/assets/lottie/rain.json';
import snow from '@/assets/lottie/snow.json';
import thunderStorm from '@/assets/lottie/thunderstorm.json';
import clouds from '@/assets/lottie/cloudy.json';
import etc from '@/assets/lottie/weather/etc.json';

const style = {
  width: '20%',
  minWidth: '120px',
};

const backgroundStyle = {
  width: '20%',
  minWidth: '120px',
  padding: '10px',
  boxSizing: 'border-box' as const,
  backgroundColor: '#00000030',
  borderRadius: '50%',
};

export function Sunny() {
  return <Lottie animationData={sunny} style={style} />;
}
export function Rain() {
  return <Lottie animationData={rain} style={backgroundStyle} />;
}
export function Snow() {
  return <Lottie animationData={snow} style={backgroundStyle} />;
}
export function ThunderStorm() {
  return <Lottie animationData={thunderStorm} style={backgroundStyle} />;
}
export function Clouds() {
  return <Lottie animationData={clouds} style={backgroundStyle} />;
}
export function Etc() {
  return <Lottie animationData={etc} style={backgroundStyle} />;
}
