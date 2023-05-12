import { useState } from 'react';

function useSelect<T>(initialState: T) {
  const [value, setValue] = useState<T | string>(initialState);

  const changeValue = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setValue(e.target.value);
  };

  const defaultValue = () => {
    setValue('');
  };

  return { value, setValue: changeValue, defaultValue };
}

export default useSelect;
