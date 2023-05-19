import Lottie from 'lottie-react';
import etc from '@/assets/lottie/weather/etc.json';

const style = {
  width: '125px',
};

function Etc() {
  return <Lottie animationData={etc} style={style} />;
}

export default Etc;
