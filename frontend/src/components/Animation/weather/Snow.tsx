import Lottie from 'lottie-react';
import snow from '@/assets/lottie/weather/snow.json';

const style = {
  width: '125px',
};

function Snow() {
  return <Lottie animationData={snow} style={style} />;
}

export default Snow;
