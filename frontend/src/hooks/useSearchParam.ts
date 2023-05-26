import { useState } from 'react';

function useSearchParam<T>(initialState: T) {
  const [value, setValue] = useState<string | null>('');

  const changeValue = (param: string) => {
    const getParam = (param: string) => {
      return new URLSearchParams(location.search).get(param);
    };

    setValue(getParam(param));
  };

  return { value, setValue: changeValue };
}

export default useSearchParam;
