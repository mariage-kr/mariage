import { useEffect, useState } from 'react';

import { ScrollTop } from 'components/Animation';

import * as S from './ScrollToTop.styled';

function ScrollToTop() {
  const [isShow, setIsShow] = useState(false);

  useEffect(() => {
    const handleShowButton = () => {
      if (window.scrollY > 250) {
        setIsShow(true);
      } else {
        setIsShow(false);
      }
    };

    window.addEventListener('scroll', handleShowButton);
    return () => {
      window.removeEventListener('scroll', handleShowButton);
    };
  });

  const toTop = () => {
    window.scroll({
      top: 0,
      behavior: 'smooth',
    });
  };

  return (
    <S.Container>
      {isShow && (
        <S.Button onClick={toTop}>
          <ScrollTop />
        </S.Button>
      )}
    </S.Container>
  );
}

export default ScrollToTop;
