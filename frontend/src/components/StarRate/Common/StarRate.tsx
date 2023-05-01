import React from "react";
import StarRateMethod from "./StarRateMethod";

const StarRate=() => {
    const [rating, setRating] = React.useState(0);
  
    return (
        <div> 
    <StarRateMethod
          count={5}
          value={rating}
          edit={true}
          onChange={(value) => setRating(value)}
        />
        <p>
            {/* TODO: 페이지에 맞게 스타일 변경 */}
          <b>별점: </b>
          <span>{rating}</span>점
        </p>
        </div>
    );
  };
  
  export default StarRate;