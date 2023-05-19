import Lottie from 'lottie-react';
import snow from 'assets/lottie/weather/snow.json';

const style = {
  width: '40%',
  maxHeight: '3rem',
  margin: '0 auto',
};

function Snow() {
  return <Lottie animationData={snow} style={style} />;
}

export default Snow;
