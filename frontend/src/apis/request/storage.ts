import { axiosWithAccessToken } from '../axios';

import { API_PATH } from '@/constants/path';
import { ImageIdType } from '@/types/id';

const requestSaveImage = (image: File) => {
  const formData = new FormData();
  formData.append('file', image);

  return axiosWithAccessToken
    .post<ImageIdType>(API_PATH.STORAGE.SAVE, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    })
    .then(response => response.data);
};

export { requestSaveImage };
