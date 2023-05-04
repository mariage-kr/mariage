import { css } from '@emotion/react';
import { useState } from 'react';
import {
    Wrapper as wrapperStyles,
    SelectedOption as selectedOptionStyles,
    Arrow as arrowStyles,
    OptionsContainer as optionsContainerStyles,
    OptionItem as optionItemStyles
  } from './SelectButton.styled';

const SelectButtonDrinktype = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState('술종류');

  const options = [
    {
      id: 1,
      value: '소주',
    },
    {
      id: 2,
      value: '맥주',
    },
        {
      id: 3,
      value: '전통주',
    },
    {
      id: 4,
      value: 'etc',
    }
  ];

  const handleOptionClick = (value: string) => {
    setSelectedOption(value);
    setIsOpen(false);
  };

  return (
    <div css={wrapperStyles}>
      <div css={selectedOptionStyles(isOpen)} onClick={() => setIsOpen(!isOpen)}>
        {selectedOption}
				<div css={arrowStyles}></div>
      </div>
      {isOpen && (
        <div css={optionsContainerStyles}>
          {options.map((option) => (
            <div
              css={optionItemStyles}
              key={option.id}
              onClick={() => handleOptionClick(option.value)}
            >
              {option.value}
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default SelectButtonDrinktype;