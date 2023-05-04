import { useState } from 'react';
import * as S  from './SelectButton.styled';

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
    <S.Wrapper>
      <S.SelectedOption isOpen={isOpen} onClick={() => setIsOpen(!isOpen)}>
        {selectedOption}
        <S.Arrow />
      </S.SelectedOption>
      {isOpen && (
        <S.OptionsContainer>
          {options.map((option) => (
            <S.OptionItem
              key={option.id}
              onClick={() => handleOptionClick(option.value)}
            >
              {option.value}
            </S.OptionItem>
          ))}
        </S.OptionsContainer>
      )}
    </S.Wrapper>
  );
};

export default SelectButtonDrinktype;