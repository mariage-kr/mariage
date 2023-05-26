import styled from '@emotion/styled';

import America from './america.png';
import Australia from './australia.png';
import Austria from './austria.png';
import Belgium from './belgium.png';
import Brazil from './brazil.png';
import Bulgaria from './bulgaria.png';
import Canada from './canada.png';
import China from './china.png';
import Denmark from './denmark.png';
import England from './england.png';
import Estonia from './estonia.png';
import Finland from './finland.png';
import France from './france.png';
import Germany from './germany.png';
import Greece from './greece.png';
import Hungary from './hungary.png';
import India from './india.png';
import Ireland from './ireland.png';
import Italy from './italy.png';
import Japan from './japan.png';
import Korea from './korea.png';
import Mexico from './mexico.png';
import Norway from './norway.png';
import Philippine from './philippine.png';
import Poland from './poland.png';
import Russia from './russia.png';
import Scotland from './scotland.png';
import Spain from './spain.png';
import Swiss from './swiss.png';
import Taiwan from './taiwan.png';
import Thailand from './thailand.png';
import Vietnam from './vietnam.png';

type CountryType = {
  id: number;
};

const FlagImg = styled.img`
  border-radius: 100%;
  box-shadow: 0px 0px 10px #9c94d044;
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

function CountryFlagImg({ id }: CountryType) {
  if (id === 1) {
    return <FlagImg src={America} />;
  }
  if (id === 2) {
    return <FlagImg src={Australia} />;
  }
  if (id === 3) {
    return <FlagImg src={Austria} />;
  }
  if (id === 4) {
    return <FlagImg src={Belgium} />;
  }
  if (id === 5) {
    return <FlagImg src={Brazil} />;
  }
  if (id === 6) {
    return <FlagImg src={Bulgaria} />;
  }
  if (id === 7) {
    return <FlagImg src={Canada} />;
  }
  if (id === 8) {
    return <FlagImg src={China} />;
  }
  if (id === 9) {
    return <FlagImg src={Denmark} />;
  }
  if (id === 10) {
    return <FlagImg src={England} />;
  }
  if (id === 11) {
    return <FlagImg src={Estonia} />;
  }
  if (id === 12) {
    return <FlagImg src={Finland} />;
  }
  if (id === 13) {
    return <FlagImg src={France} />;
  }
  if (id === 14) {
    return <FlagImg src={Germany} />;
  }
  if (id === 15) {
    return <FlagImg src={Greece} />;
  }
  if (id === 16) {
    return <FlagImg src={Hungary} />;
  }
  if (id === 17) {
    return <FlagImg src={India} />;
  }
  if (id === 18) {
    return <FlagImg src={Ireland} />;
  }
  if (id === 19) {
    return <FlagImg src={Italy} />;
  }
  if (id === 20) {
    return <FlagImg src={Japan} />;
  }
  if (id === 21) {
    return <FlagImg src={Korea} />;
  }
  if (id === 22) {
    return <FlagImg src={Mexico} />;
  }
  if (id === 23) {
    return <FlagImg src={Norway} />;
  }
  if (id === 24) {
    return <FlagImg src={Philippine} />;
  }
  if (id === 25) {
    return <FlagImg src={Poland} />;
  }
  if (id === 26) {
    return <FlagImg src={Russia} />;
  }
  if (id === 27) {
    return <FlagImg src={Scotland} />;
  }
  if (id === 28) {
    return <FlagImg src={Spain} />;
  }
  if (id === 29) {
    return <FlagImg src={Swiss} />;
  }
  if (id === 30) {
    return <FlagImg src={Taiwan} />;
  }
  if (id === 31) {
    return <FlagImg src={Thailand} />;
  }
  return <FlagImg src={Vietnam} />;
}

export default CountryFlagImg;
