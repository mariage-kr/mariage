import { useRecoilState } from 'recoil';

import { userNicknameState } from '@/store/status';
import { useCallback } from 'react';
import { requestUserNickname } from '@/apis/request/member';

function useNickname() {
  const [value, setValue] = useRecoilState(userNicknameState);

  const saveUserNickname = useCallback(() => {
    requestUserNickname().then(response => {
      const nickname: string = response.data.nickname;
      setValue(nickname);
    });
  }, []);

  return { value, setValue: saveUserNickname };
}
