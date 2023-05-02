import React, { useState } from 'react';
import * as S from './StarRating.styled';

interface RatingProps {
  className?: string;
  count: number;
  value: number;
  color?: string;
  hoverColor?: string;
  activeColor?: string;
  edit?: boolean;
  onChange?: (value: number) => void;
  emptyIcon?: React.ReactElement;
  fullIcon?: React.ReactElement;
}

interface StarProps {
  width?: number;
  height?: number;
  color?: string;
  filled?: boolean;
}

const Star = ({ width = 20, height = 20, color, filled }: StarProps) => {
  const path =
    'M10 16.0737L16.18 20L14.54 12.6L20 7.62105L12.81 6.96842L10 0L7.19 6.96842L0 7.62105L5.45 12.6L3.82 20L10 16.0737Z';
  const fillColor = color ?? (filled ? '#9C94D0' : '#E9E6FF');

  return (
    <div>
      <svg width={width} height={height} viewBox="0 0 20 20">
        <path d={path} fill={fillColor} />
        <path fill="none" />
      </svg>
    </div>
  );
};

const FullStar = (props: StarProps) => (
  <Star {...props} filled color="#9C94D0" />
);
const EmptyStar = (props: StarProps) => (
  <Star {...props} filled={false} color="#E9E6FF" />
);

const StarRating: React.FC<RatingProps> = ({
  className,
  count,
  value,
  color = '#E9E6FF',
  hoverColor = '#9C94D0',
  activeColor = '#9C94D0',
  edit = false,
  onChange,
  emptyIcon = <EmptyStar />,
  fullIcon = <FullStar />,
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
          color: getColor(i),
        })}
      </S.StarStyle>,
    );
  }

  return (
    <S.Container className={`rating ${className}`}>{starList}</S.Container>
  );
};
export default StarRating;
