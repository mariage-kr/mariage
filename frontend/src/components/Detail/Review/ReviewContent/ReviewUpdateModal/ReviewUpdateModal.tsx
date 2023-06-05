import React, { PropsWithChildren } from 'react';
import * as S from './ReviewUpdateModal.styled';

interface ModalDefaultType {
  onClickReviewUpdate: () => void;
}

function ReviewUpdateModal({
  onClickReviewUpdate,
  children,
}: PropsWithChildren<ModalDefaultType>) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.DialogBox>{children}</S.DialogBox>
        <S.Backdrop
          onClick={(e: React.MouseEvent) => {
            e.preventDefault();
            if (onClickReviewUpdate) {
              onClickReviewUpdate();
            }
          }}
        />
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewUpdateModal;