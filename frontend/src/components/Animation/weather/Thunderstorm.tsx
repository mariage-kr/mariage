import Lottie from 'lottie-react';
import thunderstorm from '@/assets/lottie/weather/thunderstorm.json';

const style = {
  width: '40%',
  maxHeight: '3rem',
  margin: '0 auto',
};

function Thunderstorm() {
  return <Lottie animationData={thunderstorm} style={style} />;
}

export default Thunderstorm;
