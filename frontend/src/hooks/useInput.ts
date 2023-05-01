import { useState } from 'react';

function useInput<T>(initialState: T) {
  const [value, setValue] = useState<T | string>(initialState);

  const changeValue = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
  ) => {
    setValue(e.target.value);
  };

  return { value, setValue: changeValue };
}

export default useInput;
