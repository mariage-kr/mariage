import { useState } from 'react';

const useInput = () => {
  const [value, setValue] = useState<string>();

  const changeValue = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
  ) => {
    setValue(e.target.value);
  };

  return { value, setValue: changeValue };
};

export default useInput;
