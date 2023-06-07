import { useEffect, useState } from 'react';

function useImage<T>(initialState: T | File | null) {
  const [value, setValue] = useState<T | File | null>(initialState);
  const [preview, setPreview] = useState<string | undefined>(undefined);

  const changeValue = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (file) {
      const allowedExtensions = ['.jpg', '.jpeg', '.png'];
      const fileExtension = file.name.split('.').pop()?.toLowerCase();

      if (fileExtension && allowedExtensions.includes(`.${fileExtension}`)) {
        setValue(file);
      } else {
        alert('이미지 형식의 파일을 선택해주세요.');
      }
    }
  };

  const changePreview = () => {
    if (value) {
      const reader = new FileReader();

      reader.onloadend = () => {
        setPreview(reader.result as string);
      };

      if (value instanceof Blob) {
        reader.readAsDataURL(value);
      }
    } else {
      setPreview(undefined);
    }
  };

  const resetImage = () => {
    setValue(null);
  };

  useEffect(() => {
    changePreview();
  }, [value]);

  return { value, setValue: changeValue, preview, resetImage };
}

export default useImage;
