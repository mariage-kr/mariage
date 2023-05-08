import { useEffect, useState } from 'react';
import * as S from './SelectBox.styled';

import useSelect from '@/hooks/useSelect';

interface Options {
  value: string;
  name: string;
}

function SelectBox() {
  const mainOptions = [
    { value: 'domestic', name: '국내' },
    { value: 'overseas', name: '해외' },
  ];

  // 국내
  const domesticOptions = [
    { value: 'soju', name: '소주' },
    { value: 'beer', name: '맥주' },
    { value: 'traditionalLiquor', name: '전통주' },
    { value: 'etc', name: 'etc' },
  ];

  // 해외
  const overseasOptions = [
    { value: 'spirits', name: '증류주' },
    { value: 'beer', name: '맥주' },
    { value: 'wine', name: '와인' },
    { value: 'whisky', name: '위스키' },
    { value: 'etc', name: 'etc' },
  ];

  const { value: option, setValue: setOption } = useSelect(mainOptions[0].value);
  const [middle, setMiddle] = useState<Options[]>([]);

  // const { value: middleOption, setValue: setMiddleOption } = useSelect(domesticOptions[0].value, overseasOptions[0].value);

  const onChangeHanlder = (option: string) => {
    if (option === 'domestic') {
      setMiddle(domesticOptions);
    } else {
      setMiddle(overseasOptions);
    }
  };

  useEffect(() => {
    onChangeHanlder(option);
  }, [onChangeHanlder, option]);

  const [currentValue, setCurrentValue] = useState(mainOptions[0].name);
  const [showOptions, setShowOptions] = useState(false);

  const handleSelectValue = (e : any) => {
	  setCurrentValue(e.target.getAttribute("value"));
  };

  return (
    <S.Container>
      <label>
        <S.SelectBox onChange={setOption}>
          {mainOptions.map(mainOption => (
            <S.Option key={mainOption.value} value={mainOption.value}>
            {mainOption.name}
            </S.Option>
          ))}
        </S.SelectBox>
      </label>
      <label>
        <S.SelectBox>
          {middle.map((domesticOption, index) => (
            <S.Option key={index} value={domesticOption.value}>
              {domesticOption.name}
            </S.Option>
          ))}
        </S.SelectBox>
      </label>
    </S.Container>
  );
}

export default SelectBox;
