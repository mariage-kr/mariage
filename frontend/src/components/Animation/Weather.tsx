import Lottie from 'lottie-react';
import sunny from '@/assets/lottie/sunny.json';
import rain from '@/assets/lottie/rain.json';
import snow from '@/assets/lottie/snow.json';
import thunderStorm from '@/assets/lottie/thunderstorm.json';
import cloudy from '@/assets/lottie/cloudy.json';
import sandDust from '@/assets/lottie/sand-dust.json';

const style = {
  width: '20%',
  minWidth: '100px',
};

export function Sunny() {
  return <Lottie animationData={sunny} style={style} />;
}
export function Rain() {
  return <Lottie animationData={rain} style={style} />;
}
export function Snow() {
  return <Lottie animationData={snow} style={style} />;
}
export function ThunderStorm() {
  return <Lottie animationData={thunderStorm} style={style} />;
}
export function Cloudy() {
  return <Lottie animationData={cloudy} style={style} />;
}
export function SandDust() {
  return <Lottie animationData={sandDust} style={style} />;
}
