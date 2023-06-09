import React, { PropsWithChildren } from 'react';
import * as S from './ReviewEditModal.styled';

interface ModalDefaultType {
  onClickReviewEdit: () => void;
}

function ReviewEditModal({
  onClickReviewEdit,
  children,
}: PropsWithChildren<ModalDefaultType>) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.DialogBox>{children}</S.DialogBox>
        <S.Backdrop
          onClick={(e: React.MouseEvent) => {
            e.preventDefault();
            if (onClickReviewEdit) {
              onClickReviewEdit();
            }
          }}
        />
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewEditModal;
