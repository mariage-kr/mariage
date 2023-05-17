import { useRecoilState } from 'recoil';

import { UserInfoType } from '@/@types/user';
import { userInfoState } from '@/store/status';

function useUserInfo() {
  const [userInfo, setUserInfo] = useRecoilState<UserInfoType>(userInfoState);

  const changeUserInfo = ({ id, nickname }: UserInfoType) => {
    const newUserInfo = {
      id: id,
      nickname: nickname,
    };

    setUserInfo(newUserInfo);
  };

  return { userInfo, setUserInfo: changeUserInfo };
}

export default useUserInfo;
