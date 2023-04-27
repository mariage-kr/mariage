import React, {useState} from 'react';
import * as S from './Like.styled'; 
import { ReactComponent as Like } from '../../../assets/svg/thumbs-up.svg';

interface LikeButtonProps {
  liked: boolean;
  onClick: () => void;
}

const LikeButton = (props: LikeButtonProps) => {
  const [liked, setLiked] = useState(props.liked);

  const handleButtonClick = () => {
    setLiked(!liked);
  }

  return (
    
    <S.Button liked={liked} onClick={handleButtonClick}>
      <S.Container>
        <Like fill={liked ? 'white' : 'black'} />
        {/* TODO: 더미데이터 */}
        <S.Number liked={liked}>10</S.Number>
      </S.Container>
    </S.Button>
  );
};

export default LikeButton;