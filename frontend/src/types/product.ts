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

export { ProductSaveType, ProductUpdateType };
