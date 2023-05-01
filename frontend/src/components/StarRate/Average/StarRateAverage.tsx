import  { useEffect, useState } from 'react';
import * as S from './StarRateAverage.styled';

  function StarRateAverage() {
    // TODO: 더미데이터
    const averageRate = 3.6;  
    const starIdList = ['1', '2', '3', '4', '5'];
    const [starRateList, setStarRateList] = useState([0, 0, 0, 0, 0]);

    const calculateStarRate = () => {
        let ratioStarList = [0, 0, 0, 0, 0];
        let scoreSet = averageRate*20;
        let index = 0;
        while (scoreSet > 20) {
            ratioStarList[index] = 20;
            index += 1;
            scoreSet -= 20;
        }
        ratioStarList[index] = scoreSet;
        return ratioStarList;
    };

    useEffect(() => {
        setStarRateList(calculateStarRate)
    }, [])

    return (
        <div>
          {starIdList.map((item, index) => {
            return (
              <span key={`${item}_${index}`}>
                <S.StarSvgStyle >
               <path
             id={`${item}Star`}
             d='M10 16.0737L16.18 20L14.54 12.6L20 7.62105L12.81 6.96842L10 0L7.19 6.96842L0 7.62105L5.45 12.6L3.82 20L10 16.0737Z'
         />
            <clipPath id={`${item}Clip`}>
                 <rect width={`${starRateList[index]}`} height='25' />
           </clipPath>
         <use clipPath={`url(#${item}Clip)`} href={`#${item}Star`} fill='#9C94D0'
         />
     </S.StarSvgStyle>
              </span>
            );
          })}
        </div>
      );
    }
  
  export default StarRateAverage;