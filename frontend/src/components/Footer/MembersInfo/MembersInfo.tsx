import { BROWSER_PATH } from '@/constants/path';
import * as S from './MembersInfo.styled';

function MembersInfo() {
  return (
    <>
      <S.Container>
        <S.Member>
          팀원
          <br />
          김미림 김아민 김정욱
          <br /> 박혜리 신수민
        </S.Member>
      </S.Container>
    </>
  );
}

export default MembersInfo;
