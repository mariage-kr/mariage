import styled from '@emotion/styled';

const Wrapper = styled.div`
  position: relative;
  width: 150px;
  height: 50px;
`;

const SelectedOption = styled.div<{ isOpen: boolean }>`
  position: relative;
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 100%;
  padding: 0 10px;
  font-size: 14px;
  color: #000000;
  background-color: #9c94d0;
  border-radius: 10px;
  cursor: pointer;
  transition: all 0.3s ease-in-out;

  &:hover {
    background-color: #a8a2d4;
  }

  ${props =>
  props.isOpen &&
  `
    background-color: #a8a2d4;
  `}
`;

const Arrow = styled.div`
  position: absolute;
  top :16px;
  right: 15px;
  width :0;
  height :0;
  pointer-events: none;
  border-style :solid;
  border-width: 8px 5px 0 5px;
  border-color: #9c94d0 transparent transparent transparent;
`;

const OptionsContainer = styled.div`
  position: absolute;
  top: calc(100% + 5px);
  left: 0;
  width: 100%;
  max-height: 100px;
  overflow-y: auto;
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
  z-index: 999;
`;

const OptionItem = styled.div`
  padding: 10px;
  font-size: 14px;
  color: #000000;
  cursor: pointer;
  transition: all 0.3s ease-in-out;

  &:hover {
    background-color: #f2f2f2;
  }
`;

export {Wrapper, SelectedOption, Arrow, OptionItem, OptionsContainer};