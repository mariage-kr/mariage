import styled from '@emotion/styled';
import { css } from '@emotion/react';

const SearchBox = styled.div`
  position: relative;
  display: flex;
  width: 30vw;
  margin: 0 auto;
`;

const Search = styled.input`
  width: 80%;
  padding: 10px;
  border: 1px solid #000;
  border-radius: 30px;
  font-size: 1rem;

  &&:focus {
    border: 3px solid #9c94d0;
    outline: none;
  }
`;

const SearchImg = css`
  position: absolute;
  top: 10px;
  right: 20%;
  width: 25px;
  height: 25px;
  z-index: 10;
`;

export { SearchBox, Search, SearchImg };
