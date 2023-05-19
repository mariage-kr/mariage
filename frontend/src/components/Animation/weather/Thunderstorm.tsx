import Lottie from 'lottie-react';
import thunderstorm from '@/assets/lottie/weather/thunderstorm.json';

const style = {
  width: '125px',
};

function Thunderstorm() {
  return <Lottie animationData={thunderstorm} style={style} />;
}

export default Thunderstorm;
