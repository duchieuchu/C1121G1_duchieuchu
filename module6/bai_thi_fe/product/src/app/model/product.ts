import {Category} from './category';

export interface Product {
  id?: number;
  code?: string;
  name?: string;
  price?: number;
  status?: string;
  importDate?: string;
  isDeleted?: boolean;
  category?: Category;

  made?: string;
  gas?: boolean;
  sweat?: boolean;
  author?: string;
  typeBook?: string;
  publicationDate?: string;

}
