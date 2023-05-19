import Lottie from 'lottie-react';
import etc from 'assets/lottie/weather/etc.json';

const style = {
  width: '40%',
  maxHeight: '3rem',
  margin: '0 auto',
};

function Etc() {
  return <Lottie animationData={etc} style={style} />;
}

export default Etc;
