import { requestDeleteImage, requestSaveImage } from '@/apis/request/storage';

const deleteImage = async (imageId: number) => {
  await requestDeleteImage(imageId);
};

const saveImage = async (image: File | null) => {
  let imageId: number | null = null;
  if (image) {
    await requestSaveImage(image).then(data => {
      imageId = data.imageId;
    });
  }

  return imageId;
};

export { saveImage, deleteImage };
