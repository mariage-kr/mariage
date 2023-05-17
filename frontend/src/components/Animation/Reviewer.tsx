import Lottie from 'lottie-react';
import review from '@/assets/lottie/review.json';

const style = {
  width: '10%',
  maxHeight: '3rem',
};

function Reviewer() {
  return <Lottie animationData={review} style={style} />;
}

export default Reviewer;
