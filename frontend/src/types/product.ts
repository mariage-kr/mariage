type ProductInfoType = {
  name: string;
  info: string;
  level: number;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
  imageUrl: string;
};

type ProductSaveType = {
  name: string;
  level: number;
  info: string;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
};

type ProductUpdateType = {
  id: number;
  name: string;
  level: number;
  info: string;
  country: string;
  upperCategory: string;
  lowerCategory: string;
  imageId: number;
  newImageId: number;
};

export { ProductInfoType, ProductSaveType, ProductUpdateType };
