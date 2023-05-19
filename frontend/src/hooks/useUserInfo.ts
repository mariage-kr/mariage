import { useRecoilState, useSetRecoilState } from 'recoil';

import { UserInfoType } from 'types/user';
import { userInfoState } from 'store/status';

function useUserInfo() {
  const [userInfo, setUserInfo] = useRecoilState<UserInfoType | undefined>(
    userInfoState,
  );
  const defaultUserInfo = useSetRecoilState<UserInfoType | undefined>(
    userInfoState,
  );

  const changeUserInfo = ({ id, nickname }: UserInfoType) => {
    const newUserInfo = {
      id: id,
      nickname: nickname,
    };

    setUserInfo(newUserInfo);
  };

  const resetUserInfo = () => {
    defaultUserInfo(undefined);
  };

  return { userInfo, setUserInfo: changeUserInfo, resetUserInfo };
}

export default useUserInfo;
