import { useEffect, useState } from 'react';

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
  });

  return <S.Container>{isShow && <S.Button />}</S.Container>;
}

export default ScrollToTop;
