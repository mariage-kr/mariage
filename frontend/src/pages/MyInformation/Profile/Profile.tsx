import * as S from './Profile.styled';
import user from '../../../assets/svg/user.svg';

import axios from 'axios';
import React, { useCallback, useRef, useState } from 'react';

function Profile() {
  const [imageUrl, setImageUrl] = useState<String | null>(null);
  const [nickname, setNickname] = useState<String>('마리아');
  const inputRef = useRef<HTMLInputElement | null>(null);

  const onUploadImage = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      if (!e.target.files) {
        return;
      }

      const formData = new FormData();
      formData.append('image', e.target.files[0]);

      axios({
        /* TODO: 임시 주소입니다. */
        baseURL: API_HOST,
        url: '/images/:username/thumbnail',
        method: 'POST',
        data: formData,
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      })
        .then(response => {
          e.preventDefault();
          console.log(response.data);
          setImageUrl(URL.createObjectURL(e.target.files[0]));
        })
        .catch(error => {
          console.error(error);
        });
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
    setImageUrl(null);
  }, []);

  const onNicknameChange = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      setNickname(e.target.value);
    },
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
            {imageUrl ? (
              <S.Profileimg src={imageUrl} />
            ) : (
              <S.Profileimg src={user} />
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
          <S.Nickname
            type="text"
            name="nickname"
            id="nickname"
            placeholder="변경할 닉네임을 입력해 주세요."
            onChange={onNicknameChange}
          />
          <S.BtnSubmit type="submit" onClick={onSubmitNickname}>
            닉네임 변경
          </S.BtnSubmit>
        </S.NicknameWrap>
      </S.Container>
    </>
  );
}

export default Profile;
