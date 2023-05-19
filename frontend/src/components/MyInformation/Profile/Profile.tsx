import { useEffect, useState, useRef } from 'react';

import {
  requestUserInfo,
  requestUpdateNickname,
  requestUserProfile,
} from 'apis/request/member';
import useImage from 'hooks/useImage';
import useInput from 'hooks/useInput';
import { UserProfileType } from 'types/user';

import * as S from './Profile.styled';
import useUserInfo from 'hooks/useUserInfo';

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

  /* 사진 변경 */
  // const {
  //   value: Image,
  //   setValue: setImage,
  //   preview,
  // } = useImage<File | null>(null);

  // const imageInput = useRef<HTMLInputElement>(null);

  // //버튼 클릭시 input태그에 클릭이벤트 적용
  // const onClickUpdateBtn = () => {
  //   imageInput.current!.click();
  // };

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
        /* TODO: 추후 에러 문구를 출력하는 방향으로 수정 */
        console.error(error);
      });
  };

  return (
    <S.Container>
      <S.Profile>
        <S.ProfileImage>
          <S.Text>프로필 사진</S.Text>
          <S.ImgWrap>
            <S.Img src={userProfile?.imagePath} />
            {/* <S.UpdateImg src={preview} css={Image == null ? S.updateImg1 : S.updateImg2}/> */}
          </S.ImgWrap>
        </S.ProfileImage>

        <S.Info>
          <S.Name>
            {userProfile?.nickname} <S.Email>{userProfile?.email}</S.Email>
          </S.Name>
          <S.Birth>{userProfile?.birth}</S.Birth>
          <form encType="multipart/form-data">
            <S.ImageInput
              type="file"
              accept="image/*"
              onChange={setImage}
              title={'프로필 수정'}
              // ref={imageInput}
            />
            <S.Btn type={'button'} /*onClick={onClickUpdateBtn}*/>
              사진변경
            </S.Btn>
            <S.Btn type={'button'}>삭제</S.Btn>
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
