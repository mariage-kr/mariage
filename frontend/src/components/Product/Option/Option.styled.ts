import styled from '@emotion/styled';

const Container = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  width: 140px;
  display: flex;
  flex-direction: row;
`;

const Btn = styled.button`
  position: relative;
  width: 70px;
  padding-left: 10px;
  font-size: 0.8rem;
  background-color: transparent;
  transition: all 0.15s;

  &:hover,
  :focus {
    font-weight: bold;
    text-shadow: 1px 5px 10px #9c94d0;
  }

  &::before {
    position: absolute;
    content: '◎';
    top: 0;
    left: 0;
    width: 3px;
    height: 3px;
    opacity: 0;
  }

  &:hover::before,
  :focus::before {
    opacity: 1;
    color: #9c94d0;
  }
`;

export { Container, Btn };
