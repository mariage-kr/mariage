import Lottie from 'lottie-react';
import clouds from '@/assets/lottie/weather/clouds.json';

const style = {
  width: '125px',
};

function Clouds() {
  return <Lottie animationData={clouds} style={style} />;
}

export default Clouds;
