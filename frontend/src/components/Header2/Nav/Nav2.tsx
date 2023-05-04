import { useState } from 'react';
import * as S from './Nav2.styled';
import { ReactNode } from 'react';
import Depth from './Depth';
import { SerializedStyles } from '@emotion/react';

interface InoutProps {
  children: ReactNode;
  onMouseEnter: () => void;
  onMouseLeave: () => void;
  handleMouseOver: () => void;
  css: SerializedStyles;
}

const Inout = ({
  children,
  onMouseEnter,
  onMouseLeave,
  handleMouseOver,
}: InoutProps) => {
  return (
    <S.Inout
      onMouseEnter={onMouseEnter}
      onMouseLeave={onMouseLeave}
      onMouseOver={handleMouseOver}
      css={S.UnderBar}
    >
      {children}
    </S.Inout>
  );
};

interface NavProps {
  onMouseEnter: () => void;
  onMouseLeave: () => void;
  handleMouseOver: () => void;
  showDropdown: boolean;
}

const Nav = ({
  onMouseEnter,
  onMouseLeave,
  handleMouseOver,
  showDropdown,
}: NavProps) => {
  const [showKAlcohol, setShowKAlcohol] = useState<boolean>(false);
  const [showGAlcohol, setShowGAlcohol] = useState<boolean>(false);

  const handleShowKAlcohol = () => {
    setShowKAlcohol(true);
  };

  const handleHideKAlcohol = () => {
    setShowKAlcohol(false);
  };

  const handleShowGAlcohol = () => {
    setShowGAlcohol(true);
  };

  const handleHideGAlcohol = () => {
    setShowGAlcohol(false);
  };

  interface DepthProps {
    kAlcohol?: boolean;
    gAlcohol?: boolean;
  }

  return (
    <>
      <S.NavBlock>
        <S.Category>
          <Inout
            onMouseEnter={handleShowKAlcohol}
            onMouseLeave={handleHideKAlcohol}
            handleMouseOver={handleShowKAlcohol}
            css={S.UnderBar}
          >
            국내
          </Inout>
          <Inout
            onMouseEnter={handleShowGAlcohol}
            onMouseLeave={handleHideGAlcohol}
            handleMouseOver={handleShowGAlcohol}
            css={S.UnderBar}
          >
            해외
          </Inout>
        </S.Category>
      </S.NavBlock>
      {showDropdown && ( // render the Depth component conditionally
        <>
          {showKAlcohol && <Depth showKAlcohol={true} showGAlcohol={false} />}
          {showGAlcohol && <Depth showGAlcohol={true} showKAlcohol={false} />}
        </>
      )}
    </>
  );
};

export default Nav;
