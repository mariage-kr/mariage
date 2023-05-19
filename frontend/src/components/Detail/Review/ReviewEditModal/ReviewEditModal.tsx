import React, { PropsWithChildren } from 'react';
import * as S from './ReviewEditModal.styled';

interface ModalDefaultType {
  onClickToggleModal: () => void;
}

function ReviewEditModal({
  onClickToggleModal,
  children,
}: PropsWithChildren<ModalDefaultType>) {
  return (
    <S.Container>
      <S.Wrapper>
        <S.DialogBox>{children}</S.DialogBox>
        <S.Backdrop
          onClick={(e: React.MouseEvent) => {
            e.preventDefault();

            if (onClickToggleModal) {
              onClickToggleModal();
            }
          }}
        />
      </S.Wrapper>
    </S.Container>
  );
}

export default ReviewEditModal;
