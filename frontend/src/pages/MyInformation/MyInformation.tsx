import * as S from './MyInformation.styled';

import { Link } from 'react-router-dom';

import Password from './Password/Password';
import Profile from './Profile/Profile';
import { useState } from 'react';

function MyInformation() {
  const [tabmenu, setTabmenu] = useState(0);

  return (
    <>
      <S.Navi>
        <S.Block></S.Block>
        <Link
          to="./"
          css={tabmenu === 0 ? S.ActiveTab : S.LinkStyle}
          onClick={() => setTabmenu(0)}
          onSelect={() => setTabmenu(0)}
        >
          프로필 수정
        </Link>
        <Link
          to="./"
          css={tabmenu === 1 ? S.ActiveTab : S.LinkStyle}
          onClick={() => setTabmenu(1)}
        >
          비밀번호 변경
        </Link>
      </S.Navi>
      {tabmenu === 0 && <Profile />}
      {tabmenu === 1 && <Password />}
    </>
  );
}

export default MyInformation;
