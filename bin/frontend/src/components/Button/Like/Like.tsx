import { useState } from 'react';
import * as S from './Like.styled';

import { Like } from '../../../assets/svg/SVG';

interface LikeButtonProps {
  liked: boolean;
  likeCount: number;
  onClick: () => void;
}

function LikeButton({ liked, likeCount, onClick }: LikeButtonProps) {
  const [like, setLike] = useState(liked);

  const handleButtonClick = () => {
    setLike(!like);
    onClick();
  };

  return (
    <S.Button liked={like} onClick={handleButtonClick}>
      <S.Container>
        <Like fill={like ? 'white' : 'black'} />
        <S.Number liked={like}>{likeCount}</S.Number>
      </S.Container>
    </S.Button>
  );
};

export default LikeButton;
