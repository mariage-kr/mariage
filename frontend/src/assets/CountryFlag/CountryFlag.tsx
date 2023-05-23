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

const FoodImg = styled.img`
  border-radius: 100%;
  box-shadow: 0px 0px 10px #9c94d044;
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

function CountryFlagImg({ id }: CountryType) {
  if (id === 1) {
    return <FoodImg src={America} />;
  }
  if (id === 2) {
    return <FoodImg src={Australia} />;
  }
  if (id === 3) {
    return <FoodImg src={Austria} />;
  }
  if (id === 4) {
    return <FoodImg src={Belgium} />;
  }
  if (id === 5) {
    return <FoodImg src={Brazil} />;
  }
  if (id === 6) {
    return <FoodImg src={Bulgaria} />;
  }
  if (id === 7) {
    return <FoodImg src={Canada} />;
  }
  if (id === 8) {
    return <FoodImg src={China} />;
  }
  if (id === 9) {
    return <FoodImg src={Denmark} />;
  }
  if (id === 10) {
    return <FoodImg src={England} />;
  }
  if (id === 11) {
    return <FoodImg src={Estonia} />;
  }
  if (id === 12) {
    return <FoodImg src={Finland} />;
  }
  if (id === 13) {
    return <FoodImg src={France} />;
  }
  if (id === 14) {
    return <FoodImg src={Germany} />;
  }
  if (id === 15) {
    return <FoodImg src={Greece} />;
  }
  if (id === 16) {
    return <FoodImg src={Hungary} />;
  }
  if (id === 17) {
    return <FoodImg src={India} />;
  }
  if (id === 18) {
    return <FoodImg src={Ireland} />;
  }
  if (id === 19) {
    return <FoodImg src={Italy} />;
  }
  if (id === 20) {
    return <FoodImg src={Japan} />;
  }
  if (id === 21) {
    return <FoodImg src={Korea} />;
  }
  if (id === 22) {
    return <FoodImg src={Mexico} />;
  }
  if (id === 23) {
    return <FoodImg src={Norway} />;
  }
  if (id === 24) {
    return <FoodImg src={Philippine} />;
  }
  if (id === 25) {
    return <FoodImg src={Poland} />;
  }
  if (id === 26) {
    return <FoodImg src={Russia} />;
  }
  if (id === 27) {
    return <FoodImg src={Scotland} />;
  }
  if (id === 28) {
    return <FoodImg src={Spain} />;
  }
  if (id === 29) {
    return <FoodImg src={Swiss} />;
  }
  if (id === 30) {
    return <FoodImg src={Taiwan} />;
  }
  if (id === 31) {
    return <FoodImg src={Thailand} />;
  }
  if (id === 32) {
    return <FoodImg src={Vietnam} />;
  }
}

export default CountryFlagImg;
