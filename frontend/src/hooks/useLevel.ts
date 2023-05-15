import { useState } from 'react';

function useLevel<T>(initialState: T) {
  const [level, setLevel] = useState<number>(0);

  const inputLevel = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { value } = e.target;

    const onlyNumber = parseFloat(value.replace(/[^\d.]/g, ''));
    const roundedNumber = Math.round(onlyNumber * 10) / 10;
    let finalNumber = isNaN(roundedNumber) ? 0 : roundedNumber;

    if (finalNumber > 100.0) {
      finalNumber = 100.0;
    }

    setLevel(finalNumber);
  };

  const changeLevel = (level: number) => {
    setLevel(level);
  };

  return { level, setLevel: changeLevel, inputLevel };
}

export default useLevel;
