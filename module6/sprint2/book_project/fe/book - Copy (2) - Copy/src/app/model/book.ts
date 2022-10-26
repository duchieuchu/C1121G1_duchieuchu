import {Category} from './category';

export interface Book {
  id?: number;
  bookName?: string;
  description?: string;
  price?: number;
  image?: string;
  pageNumber?: number;
  authors?: string;
  publishingHouse?: string;
  quantity?: number;
  category?: Category;
  isDeleted?: boolean;
}
