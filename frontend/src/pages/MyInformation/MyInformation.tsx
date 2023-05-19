import { useState } from 'react';
import { Link } from 'react-router-dom';

import Password from '@/components/MyInformation/Password/Password';
import Profile from '@/components/MyInformation/Profile/Profile';

import * as S from './MyInformation.styled';

function MyInformation() {
  const [tabMenu, setTabMenu] = useState(0);

  return (
    <>
      <S.Nav>
        <Link
          to="./"
          css={tabMenu === 0 ? S.ActiveTab : S.LinkStyle}
          onClick={() => setTabMenu(0)}
          onSelect={() => setTabMenu(0)}
        >
          프로필 수정
        </Link>
        <Link
          to="./"
          css={tabMenu === 1 ? S.ActiveTab : S.LinkStyle}
          onClick={() => setTabMenu(1)}
        >
          비밀번호 변경
        </Link>
      </S.Nav>
      {tabMenu === 0 && <Profile />}
      {tabMenu === 1 && <Password />}
    </>
  );
}

export default MyInformation;
