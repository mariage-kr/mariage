import Lottie from 'lottie-react';
import clouds from '@/assets/lottie/weather/clouds.json';

const style = {
  width: '40%',
  maxHeight: '3rem',
  margin: '0 auto',
};

function Clouds() {
  return <Lottie animationData={clouds} style={style} />;
}

export default Clouds;
