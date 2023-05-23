import { useState } from 'react';

function useSelect<T>(initialState: T) {
  const [value, setValue] = useState<T | string>(initialState);

  const changeValue = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setValue(e.target.value);
  };

  const resetValue = () => {
    setValue('');
  };

  const defaultValue = (data: string) => {
    setValue(data);
  };

  return { value, setValue: changeValue, resetValue, defaultValue };
}

export default useSelect;
