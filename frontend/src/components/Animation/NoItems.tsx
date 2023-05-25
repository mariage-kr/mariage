import Lottie from 'lottie-react';
import noItem from '@/assets/lottie/no-items.json';

const style = {
  width: '500px',
};

function NoItem() {
  return <Lottie animationData={noItem} style={style} />;
}

export default NoItem;
