import Lottie from 'lottie-react';
import scrollTop from 'assets/lottie/scrollTop.json';

const style = {
  scale: '2',
  margin: '20px 0 0 0',
};

function ScrollTop() {
  return <Lottie animationData={scrollTop} style={style} />;
}

export default ScrollTop;
