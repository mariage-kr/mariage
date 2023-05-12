import React, { useCallback, useEffect, useRef, useState } from 'react';

import useImage from '@/hooks/useImage';
import useInput from '@/hooks/useInput';

import * as S from './Profile.styled';
import { requestUserInfo } from '@/apis/request/member';

type UserInfoType = {
  nickname: string;
  email: string;
  imagePath: string;
  birth: string;
};

function Profile() {
  const [imageUrl, setImageUrl] = useState<string>('');
  const { value: nickname, setValue: setNickname } = useInput('');

  const { value: image, setValue: setImage } = useImage<File>(null);
  const [userInfo, setUserInfo] = useState<UserInfoType>();

  const onDeleteImage = useCallback(() => {
    setImageUrl('');
  }, []);

  const onSubmitNickname = useCallback(
    (e: React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      console.log('New nickname:', nickname);
      alert('닉네임 변경이 완료되었습니다.');
    },
    [nickname],
  );

  /* 유저 정보 요청 */
  const requestMyData = async () => {
    await requestUserInfo()
      .then(response => {
        setUserInfo(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  useEffect(() => {
    requestMyData();
  }, []);

  return (
    <S.Container>
      <S.Profile>
        <S.Image>
          <p>프로필 사진</p>
          <S.ProfileImg src={userInfo?.imagePath} />
        </S.Image>
        <S.Info>
          <S.Name>
            {userInfo?.nickname} <S.Email>{userInfo?.email}</S.Email>
          </S.Name>
          <S.Birth>{userInfo?.birth}</S.Birth>
          <form encType="multipart/form-data">
            <S.ImageInput
              type="file"
              accept="image/jpg, image/jpeg, image/png"
              onChange={setImage}
              title={'프로필 수정'}
            />
            <button type={'button'} css={S.BtnStyle}>
              사진변경
            </button>
            <button type={'button'} css={S.BtnStyle}>
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
            id="nickname"
            placeholder="변경할 닉네임을 입력해 주세요."
            onChange={setNickname}
          />
          <S.BtnSubmit type="submit">닉네임 변경</S.BtnSubmit>
        </form>
      </S.NicknameWrap>
    </S.Container>
  );
}

export default Profile;
