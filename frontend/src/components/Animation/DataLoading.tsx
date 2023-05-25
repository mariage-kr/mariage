import Lottie from 'lottie-react';
import dataLoading from '@/assets/lottie/dataLoading.json';

const style = {
  width: '100px',
};

function DataLoading() {
  return <Lottie animationData={dataLoading} style={style} />;
}

export default DataLoading;
