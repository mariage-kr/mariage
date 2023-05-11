import * as S from './Profile.styled';
import user from '../../../assets/svg/user.svg';

import React, { useCallback, useRef, useState } from 'react';
import useInput from '@/hooks/useInput';

function Profile() {
  const [imageUrl, setImageUrl] = useState<string>('');
  const { value: nickname, setValue: setNickname } = useInput('마리아');
  const inputRef = useRef<HTMLInputElement | null>(null);

  const onUploadImage = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      if (!e.target.files) {
        return;
      }

      const formData = new FormData();
      formData.append('image', e.target.files[0]);
    },
    [],
  );

  const onUploadImageButtonClick = useCallback(() => {
    if (!inputRef.current) {
      return;
    }
    inputRef.current.click();
  }, []);

  const onDeleteImage = useCallback(() => {
    setImageUrl('');
  }, []);

  const onNicknameChange = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {},
    [],
  );

  const onSubmitNickname = useCallback(
    (e: React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      console.log('New nickname:', nickname);
      alert('닉네임 변경이 완료되었습니다.');
    },
    [nickname],
  );

  return (
    <>
      <S.Container>
        <S.Profile>
          <S.Image>
            <p>프로필 사진</p>
            {imageUrl !== '' ? (
              <S.ProfileImg src={imageUrl} />
            ) : (
              <S.ProfileImg src={user} />
            )}
          </S.Image>
          <S.Info>
            <S.Name>
              {nickname} <S.Email>#mari***(이메일)</S.Email>
            </S.Name>
            <S.Birth>1990.12.30(생년월일)</S.Birth>
            <form encType="multipart/form-data">
              <input
                type="file"
                name="profileImg"
                accept="image/jpg, image/jpeg, image/png"
                ref={inputRef}
                onChange={onUploadImage}
                style={{ display: 'none' }}
              />
              <button css={S.BtnStyle} onClick={onUploadImageButtonClick}>
                사진변경
              </button>
              <button css={S.BtnStyle} onClick={onDeleteImage}>
                삭제
              </button>
            </form>
          </S.Info>
        </S.Profile>
        <S.NicknameWrap>
          <S.Label>닉네임 변경</S.Label>
          <form onSubmit={onSubmitNickname}>
            <S.Nickname
              type="text"
              name="nickname"
              id="nickname"
              placeholder="변경할 닉네임을 입력해 주세요."
              onChange={onNicknameChange}
            />
            <S.BtnSubmit type="submit">닉네임 변경</S.BtnSubmit>
          </form>
        </S.NicknameWrap>
      </S.Container>
    </>
  );
}

export default Profile;
