import Lottie from 'lottie-react';
import noReviews from '@/assets/lottie/no-reviews.json';

const style = {
  width: '15%',
  minWidth: '45px',
  maxHeight: '3rem',
};

function NoReviews() {
  return <Lottie animationData={noReviews} style={style} />;
}

export default NoReviews;
