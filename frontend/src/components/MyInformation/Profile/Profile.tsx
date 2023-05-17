import { useEffect, useState } from 'react';

import {
  requestUpdateNickname,
  requestUserProfile,
} from '@/apis/request/member';
import useImage from '@/hooks/useImage';
import useInput from '@/hooks/useInput';
import { UserProfileType } from '@/@types/user';

import * as S from './Profile.styled';

function Profile() {
  const {
    value: nickname,
    setValue: setNickname,
    resetValue: resetNickname,
  } = useInput('');

  const { value: image, setValue: setImage } = useImage<File>(null);
  const [userInfo, setUserInfo] = useState<UserProfileType>({
    nickname: '',
    email: '',
    imagePath: '',
    birth: '',
  });

  /* 유저 정보 요청 */
  const getMyInfo = async () => {
    await requestUserProfile()
      .then(response => {
        setUserInfo(response.data);
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
    await requestUpdateNickname(nickname)
      .then(response => {
        const newNickname = response.data.nickname;
        setUserInfo(prevState => {
          return { ...prevState, nickname: newNickname };
        });
        resetNickname();
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
