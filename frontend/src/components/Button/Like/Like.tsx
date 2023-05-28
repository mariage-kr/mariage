import { useCallback, useState } from 'react';

import { Like } from '@/assets/svg/SVG';
import { requestAddLike, requestRemoveLike } from '@/apis/request/like';
import useAuth from '@/hooks/useAuth';

import * as S from './Like.styled';

interface LikeButtonProps {
  reviewId: number;
  liked: boolean;
  likeCount: number;
}

function LikeButton({ reviewId, liked, likeCount }: LikeButtonProps) {
  const { isLogin } = useAuth();

  const [like, setLike] = useState({
    liked,
    likeCount,
  });

  const validateIsNotLogin = useCallback((): boolean => {
    if (isLogin()) {
      return false;
    }
    return true;
  }, []);

  const changeLike = () => {
    if (validateIsNotLogin()) {
      return;
    }
    if (!like.liked) {
      requestAddLike(reviewId).then(data => {
        setLike({
          liked: true,
          likeCount: data.likedCount,
        });
      });
    }
    if (like.liked) {
      requestRemoveLike(reviewId).then(data => {
        setLike({
          liked: false,
          likeCount: data.likedCount,
        });
      });
    }
  };

  return (
    <S.Button liked={like.liked} onClick={changeLike}>
      <S.Container>
        <Like fill={like.liked ? 'white' : 'black'} />
        <S.Number liked={like.liked}>{like.likeCount}</S.Number>
      </S.Container>
    </S.Button>
  );
}

export default LikeButton;
