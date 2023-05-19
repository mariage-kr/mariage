import Lottie from 'lottie-react';
import clear from 'assets/lottie/weather/clear.json';

const style = {
  width: '125px',
};

function Clear() {
  return <Lottie animationData={clear} style={style} />;
}

export default Clear;
