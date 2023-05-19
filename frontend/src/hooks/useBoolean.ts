import { useState } from 'react';

interface UseBooleanOutput {
  value: boolean;
  setValue: (value: boolean) => void;
  toggle: () => void;
}

function useBoolean(initialState: boolean): UseBooleanOutput {
  const [value, setValue] = useState<boolean>(initialState);

  const changeValue = (value: boolean) => {
    setValue(value);
  };

  const toggleValue = () => {
    setValue(!value);
  };

  return { value, setValue: changeValue, toggle: toggleValue };
}

export default useBoolean;
