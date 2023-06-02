import { useEffect, useState, useRef } from 'react';

import {
  requestUserInfo,
  requestUpdateNickname,
  requestUserProfile,
  requestUpdateImage,
  requestDeleteImage
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
  const imageInput = useRef<HTMLInputElement>(null);
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
  const updateImageBtn = () => {
    if (imageInput.current) {
      imageInput.current.click();
    }
  }

  const updateImage = async () => {
    if (image) {
      confirm('변경된 사진으로 적용됩니다. 정말 적용하시겠습니까?')
      const formData = new FormData();
      formData.append('file', image);
  
      await requestUpdateImage(formData)
        .then(response => {
          const newImagePath = response.data.imagePath;
          console.log(response.data)
          setUserProfile(prevState => ({
            ...prevState,
            imagePath: newImagePath,
          }));
        })
        .catch(error => {
          /* TODO: Handle error */
          console.error(error);
        });
    }
  };

  /* 사진 삭제 */
  const deleteImage = async () => {
    confirm('프로필 사진을 정말 삭제하시겠습니까?')

    await requestDeleteImage()
      .then(response => {
        const newImagePath = response.data.imagePath;
        console.log(response.data)
        setUserProfile(prevState => ({
          ...prevState,
          imagePath: newImagePath,
        }));
      })
      .catch(error => {
        /* TODO: Handle error */
        console.error(error);
      });
  };

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
              ref={imageInput}
            />
            <S.Btn type={'button'} onClick={updateImageBtn}>사진변경</S.Btn>
            <S.Btn2 type={'button'} onClick={updateImage}>적용</S.Btn2>
            <S.Btn2 type={'button'} onClick={deleteImage} css={S.deleteBtn}>삭제</S.Btn2>
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
