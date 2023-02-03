import {Category} from './category';

export interface Product {
  id?: number;
  name?: string;
  made?: string;
  dayImport?: string;
  expire?: string;
  number?: number;
  price?: number;
  image?: string;
  isDeleted?: boolean;
  category?: Category;
}

