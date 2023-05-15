import Carousel from 'react-material-ui-carousel';

import * as S from './Visual.styled';

type VisualType = {
  id: number;
  name: string;
  imageUrl: string;
};

function Visual() {
  const VisualItems: VisualType[] = [
    {
      id: 1,
      name: 'MainVisual01',
      imageUrl: 'https://i.esdrop.com/d/f/CeyD9bnnT5/PItXU6Nn1X.png',
    },
    {
      id: 2,
      name: 'MainVisual02',
      imageUrl: 'https://i.esdrop.com/d/f/CeyD9bnnT5/8rCLNMz12n.png',
    },
    {
      id: 3,
      name: 'MainVisual03',
      imageUrl: 'https://i.esdrop.com/d/f/CeyD9bnnT5/jQZt5G2dpE.jpg',
    },
  ];

  return (
    <Carousel
      indicators={false}
      autoPlay={true}
      interval={3000}
      animation="fade"
      navButtonsAlwaysInvisible={true}
    >
      {VisualItems.map((item: VisualType) => (
        <S.Visual>
          <S.Image key={item.id} src={item.imageUrl} alt={item.name} />
        </S.Visual>
      ))}
    </Carousel>
  );
}

export default Visual;
