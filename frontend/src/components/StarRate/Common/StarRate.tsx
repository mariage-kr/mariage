import React from 'react';
import StarRating from './StarRating';

const StarRate = () => {
  const [rating, setRating] = React.useState(0);

  return (
    <div>
      <StarRating
        count={5}
        value={rating}
        edit={true}
        onChange={value => setRating(value)}
      />
      {/* TODO: 페이지에 맞게 스타일 변경 */}
      <b>별점: </b>
      <span>{rating}</span>점
    </div>
  );
};

export default StarRate;
