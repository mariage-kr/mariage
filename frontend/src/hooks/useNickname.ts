import { useRecoilState } from 'recoil';

import { requestUserNickname } from '@/apis/request/member';
import { userNicknameState } from '@/store/status';

function useNickname() {
  const [value, setValue] = useRecoilState(userNicknameState);

  const saveUserNickname = (): boolean => {
    requestUserNickname().then(response => {
      const nickname: string = response.data.nickname;
      setValue(nickname);
      return true;
    });
    return false;
  };

  return { value, setValue: saveUserNickname };
}

export default useNickname;
