import Lottie from 'lottie-react';
import noItem from 'assets/lottie/no-items.json';

const style = {
  width: '40%',
  maxHeight: '3rem',
  margin: '0 auto',
};

function NoItem() {
  return <Lottie animationData={noItem} style={style} />;
}

export default NoItem;
