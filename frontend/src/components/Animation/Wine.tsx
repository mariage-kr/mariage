import Lottie from 'lottie-react';

import wine from 'assets/lottie/wine.json';

const style = {
  width: '50%',
  maxHeight: '5rem',
};

function Wine() {
  return <Lottie animationData={wine} style={style} />;
}

export default Wine;
