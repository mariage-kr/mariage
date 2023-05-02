import Carousel from 'react-material-ui-carousel'
import * as S from './Visual.styled';

function Visual() {
  const VisualItems = [
    {
      id: "1",
      name: "MainVisual01",
      image: "https://i.postimg.cc/V6fN2RTT/mainvisual01.png"
    },
    {
      id: "2",
      name: "MainVisual02",
      image: "https://i.postimg.cc/3RZ52Fb8/mainvisual02.png"
    },
    {
      id: "3",
      name: "MainVisual03",
      image: "https://i.postimg.cc/J02pVs2V/mainvisual03.jpg"
    }
  ];
 
	
  return (
    <Carousel 
      indicators={false}
      autoPlay={true}
      interval="3000"
      animation="fade"
      navButtonsAlwaysInvisible={true}
    >
      {VisualItems.map((item: any) => (
        <S.Visual>
          <S.Image key={item.id} src={item.image} alt={item.name}/>
        </S.Visual>      
      ))}
    </Carousel>
  );
}


export default Visual;