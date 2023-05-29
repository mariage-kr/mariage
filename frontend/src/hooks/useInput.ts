import { useState } from 'react';

/**
 * Input Tag의 커스텀 Hook
 * @param initialState 변수의 타입
 * @returns {string} value
 * @returns setValue
 */
function useInput<T>(initialState: T) {
  const [value, setValue] = useState<T | string>(initialState);

  const changeValue = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
  ) => {
    setValue(e.target.value);
  };

  const resetValue = () => {
    setValue('');
  };

  const defaultData = (data: string) => {
    setValue(data);
  };

  const changeSetValue = (search: string) => {
    setValue(search);
  };

  return {
    value,
    setValue: changeValue,
    resetValue,
    defaultData,
    changeSetValue,
  };
}

export default useInput;
