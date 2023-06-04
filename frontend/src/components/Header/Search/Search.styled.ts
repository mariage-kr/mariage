import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  align-items: center;

  width: 100%;
  min-width: 192px;
`;

const SearchWrapper = styled.div`
  align-items: center;
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100%;
`;

const Input = styled.input`
  width: 100%;
  height: 42px;
  border: 0;
  border-bottom: 2px solid #00000050;
  font-size: 16px;
  transition: 100ms;

  &:focus {
    outline: none;
    border-bottom: 3px solid #9c94d0;
  }

  &::placeholder {
    font-size: 1rem;
  }
`;

const ProdList = styled.ul`
  position: absolute;
  z-index: 10000;

  padding: 0;

  top: 50px;
  width: 22.7%;

  @media (max-width: 1000px) {
    width: 197px;
  }

  border: 3px solid #9c94d0;
  border-radius: 0 0 10px 10px;

  background-color: #fff;

  list-style: none;
`;

const Prod = styled.div`
  overflow: hidden;
  padding: 5px 0 5px 5px;

  font-size: 1rem;

  cursor: pointer;

  &:hover {
    text-decoration: underline;
  }
`;

const Wrapper = styled.div`
  cursor: pointer;
`;

export { Container, Input, Wrapper, SearchWrapper, ProdList, Prod };
