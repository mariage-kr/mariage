import { useState } from 'react';
import * as S  from './SelectButton.styled';

const SelectButtonRegion = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState('지역');

  const options = [
    {
      id: 1,
      value: '국내',
    },
    {
      id: 2,
      value: '해외',
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

export default SelectButtonRegion;