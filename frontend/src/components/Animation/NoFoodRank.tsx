import Lottie from 'lottie-react';
import noFoodRank from '@/assets/lottie/no-food-rank.json';

const style = {
  width: '15%',
  minWidth: '45px',
  maxHeight: '3rem',
};

function NoFoodRank() {
  return <Lottie animationData={noFoodRank} style={style} />;
}

export default NoFoodRank;
