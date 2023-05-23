import Lottie from 'lottie-react';
import soju from '@/assets/lottie/drunk-bottle.json';

const style = {
  width: '50%',
  maxHeight: '5rem',
};

function Soju() {
  return <Lottie animationData={soju} style={style} />;
}

export default Soju;
