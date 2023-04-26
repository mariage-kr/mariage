import { Global, css } from '@emotion/react';

import { fontStyle } from './fonts';

const style = () => css`
  ${fontStyle}

  body {
    font-family: 'IBMPlexSans';
    font-size: 1.1rem;
  }

  h1 {
    font-size: 2.5rem;
    color: #9c94d0;
  }

  span {
    font-family: 'NanumSquareNeo';
  }

  button {
    cursor: pointer;
  }
`;

function GlobalStyle() {
  return <Global styles={style} />;
}

export default GlobalStyle;
