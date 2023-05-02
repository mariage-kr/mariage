import styled from '@emotion/styled';
/** @jsxImportSource @emotion/react */

const Container = styled.div`
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  width: 80vw;
  height: 100px;
  margin: 0 auto;
  text-align: center;
`;

const Logo = styled.h1`
  width: 10vw;
`;

const SearchBox = styled.div`
  position: relative;
  display: flex;
  width: 35vw;
  margin: 0 auto;
`;

const Search = styled.input`
  width: 80%;
  padding: 10px;
  border: 2px solid #000;
  border-radius: 30px;
  font-size: 1rem;

  &&:focus {
    border: 3px solid #9c94d0;
    outline: none;
  }
`;

const SearchImg = styled.svg`
  position: absolute;
  top: 5px;
  right: 20%;
  width: 25px;
  height: 25px;
  z-index: 10;
`;

const Member = styled.div`
  width: 10%;
`;

// const NavBlock = styled.div`
//   width: 80vw;
//   margin: 0 auto;
//   border-bottom: 2px solid #ddd;
// `;

export { Container, Logo, SearchBox, Search, SearchImg, Member /* NavBlock */ };
