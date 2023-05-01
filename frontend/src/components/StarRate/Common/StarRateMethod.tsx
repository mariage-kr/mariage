import React, { useState } from 'react';
import { ReactComponent as EmptyStar } from '../../../assets/svg/star/emptystar.svg';
import { ReactComponent as FullStar } from '../../../assets/svg/star/fullstar.svg';
import * as S from './StarRating.styled';

interface RatingProps {
    className?: string;
    count: number;
    value: number;
    color?: string;
    hoverColor?: string;
    activeColor?: string;
    width?: number;
    height?: number;
    edit?: boolean;
    onChange?: (value: number) => void;
    emptyIcon?: React.ReactElement;
    fullIcon?: React.ReactElement;
  }
  
  const StarRate: React.FC<RatingProps> = ({
    className,
    count,
    value,
    color = "#E9E6FF",
    hoverColor = "#9C94D0",
    activeColor = "#9C94D0",
    width,
    height,
    edit = false,
    onChange,
    emptyIcon = <EmptyStar />,
    fullIcon = <FullStar />
  }) => {
    const [hoverValue, setHoverValue] = useState<number | undefined>(undefined);

  const handleMouseMove = (index: number) => {
    if (!edit) {
      return;
    }
    setHoverValue(index);
  };

  const handleMouseLeave = () => {
    if (!edit) {
      return;
    }
    setHoverValue(undefined);
  };

  const handleClick = (index: number) => {
    if (!edit) {
      return;
    }
    if (onChange) {
      onChange(index + 1);
    }
  };

  const getColor = (index: number) => {
    if (hoverValue !== undefined) {
      if (index <= hoverValue) {
        return hoverColor;
      }
    }
    if (value > index) {
      return activeColor;
    }
    return color;
  };

  const starList = [];

  for (let i = 0; i < count; i++) {
    let star: React.ReactElement;
    if (i < value) {
      star = fullIcon;
    } else {
      star = emptyIcon;
    }

    if (hoverValue !== undefined) {
      if (i <= hoverValue) {
        star = fullIcon;
      }
    }

    starList.push(
      <S.StarStyle
        key={i}
        onMouseMove={() => handleMouseMove(i)}
        onMouseLeave={handleMouseLeave}
        onClick={() => handleClick(i)}
      >
        {React.cloneElement(star, {
          color: getColor(i)
        })}
      </S.StarStyle>
    );
  }

  return <S.Container className={`rating ${className}`}>{starList}</S.Container>;
};
  export default StarRate;
