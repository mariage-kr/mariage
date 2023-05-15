import { useState } from 'react';

function useLevel<T>(initialState: T) {
  const [level, setLevel] = useState<number>(0);

  const inputLevel = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { value } = e.target;

    const finalNumber = validIsNumber(value);

    setLevel(finalNumber);
  };

  const changeLevel = (level: number) => {
    const finalNumber = validIsNumber(level);

    setLevel(finalNumber);
  };

  const validIsNumber = (number: any): number => {
    const onlyNumber = parseFloat(number.replace(/[^\d.]/g, ''));
    const roundedNumber = Math.round(onlyNumber * 10) / 10;
    let finalNumber = isNaN(roundedNumber) ? 0 : roundedNumber;

    if (finalNumber > 100.0) {
      finalNumber = 100.0;
    }

    return finalNumber;
  };

  return { level, setLevel: changeLevel, inputLevel };
}

export default useLevel;
