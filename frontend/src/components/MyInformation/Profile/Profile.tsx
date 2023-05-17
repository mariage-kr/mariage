import { useEffect, useState } from 'react';

import {
  requestUserInfo,
  requestUpdateNickname,
  requestUserProfile,
} from '@/apis/request/member';
import useImage from '@/hooks/useImage';
import useInput from '@/hooks/useInput';
import { UserProfileType } from '@/@types/user';

import * as S from './Profile.styled';
import useUserInfo from '@/hooks/useUserInfo';

function Profile() {
  const {
    value: nickname,
    setValue: setNickname,
    resetValue: resetNickname,
  } = useInput('');

  const { value: image, setValue: setImage } = useImage<File>(null);
  const [userProfile, setUserProfile] = useState<UserProfileType>({
    nickname: '',
    email: '',
    imagePath: '',
    birth: '',
  });

  const { setUserInfo } = useUserInfo();

  /* 유저 정보 요청 */
  const getMyInfo = async () => {
    await requestUserProfile()
      .then(response => {
        setUserProfile(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  useEffect(() => {
    getMyInfo();
  }, []);

  /* 닉네임 변경 */
  const updateNickname = async () => {
    const getUserInfo = async () => {
      await requestUserInfo().then(response => {
        setUserInfo({ ...response.data });
      });
    };

    await requestUpdateNickname(nickname)
      .then(response => {
        const newNickname = response.data.nickname;
        setUserProfile(prevState => {
          return { ...prevState, nickname: newNickname };
        });
        resetNickname();
        getUserInfo();
      })
      .catch(error => {
        console.error(error);
      });
  };

  return (
    <S.Container>
      <S.Profile>
        <S.Image>
          <p>프로필 사진</p>
          <S.ProfileImg src={userProfile?.imagePath} />
        </S.Image>
        <S.Info>
          <S.Name>
            {userProfile?.nickname} <S.Email>{userProfile?.email}</S.Email>
          </S.Name>
          <S.Birth>{userProfile?.birth}</S.Birth>
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
        <S.Nickname
          type="text"
          id="nickname"
          value={nickname}
          placeholder="변경할 닉네임을 입력해 주세요."
          onChange={setNickname}
        />
        <S.BtnSubmit type="submit" onClick={updateNickname}>
          닉네임 변경
        </S.BtnSubmit>
      </S.NicknameWrap>
    </S.Container>
  );
}

export default Profile;
