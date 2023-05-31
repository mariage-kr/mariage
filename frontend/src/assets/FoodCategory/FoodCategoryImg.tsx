import styled from '@emotion/styled';

import SeaFood from './seafood.png';
import Meat from './meat.png';
import BossamJokbal from './bossamjokbal.png';
import Jjigae from './jjigae.png';
import RiceNoodle from './ricenoodle.png';
import Pizza from './pizza.png';
import Chicken from './chicken.png';
import WesternFood from './westernfood.png';
import ChineseFood from './chinesefood.png';
import JapaneseFood from './japanesefood.png';
import AsianFood from './asianfood.png';
import MexicanFood from './mexicanfood.png';
import Burger from './burger.png';
import Tteokbokki from './tteokbokki.png';
import Fried from './fried.png';
import Snack from './snack.png';
import Cheese from './cheese.png';
import FruitSalad from './fruitsalad.png';
import Dessert from './dessert.png';
import ETC from './etc_smoothie.png';

const Img = styled.img`
  width: 70%;
  height: 70%;
  object-fit: cover;
`;

type FoodId = {
  id: number;
};

function FoodCategoryImg({ id }: FoodId) {
  if (id === 1) {
    return <Img src={SeaFood} />;
  }
  if (id === 2) {
    return <Img src={Meat} />;
  }
  if (id === 3) {
    return <Img src={BossamJokbal} />;
  }
  if (id === 4) {
    return <Img src={Jjigae} />;
  }
  if (id === 5) {
    return <Img src={RiceNoodle} />;
  }
  if (id === 6) {
    return <Img src={Pizza} />;
  }
  if (id === 7) {
    return <Img src={Chicken} />;
  }
  if (id === 8) {
    return <Img src={WesternFood} />;
  }
  if (id === 9) {
    return <Img src={ChineseFood} />;
  }
  if (id === 10) {
    return <Img src={JapaneseFood} />;
  }
  if (id === 11) {
    return <Img src={AsianFood} />;
  }
  if (id === 12) {
    return <Img src={MexicanFood} />;
  }
  if (id === 13) {
    return <Img src={Burger} />;
  }
  if (id === 14) {
    return <Img src={Tteokbokki} />;
  }
  if (id === 15) {
    return <Img src={Fried} />;
  }
  if (id === 16) {
    return <Img src={Snack} />;
  }
  if (id === 17) {
    return <Img src={Cheese} />;
  }
  if (id === 18) {
    return <Img src={FruitSalad} />;
  }
  if (id === 19) {
    return <Img src={Dessert} />;
  }
  return <Img src={ETC} />;
}

export default FoodCategoryImg;
