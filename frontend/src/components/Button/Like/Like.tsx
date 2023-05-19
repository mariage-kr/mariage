import { useState } from 'react';

import { Like } from 'assets/svg/SVG';

import * as S from './Like.styled';

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
}

export default LikeButton;
