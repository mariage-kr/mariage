import Lottie from 'lottie-react';
import rain from '@/assets/lottie/weather/rain.json';

const style = {
  width: '125px',
};

function Rain() {
  return <Lottie animationData={rain} style={style} />;
}

export default Rain;
