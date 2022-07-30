import {Product} from './product';

export interface ProductBlock {
  id?: number;
  code?: string;
  product?: Product;
  quantity?: number;
  dateImport?: string;
  dateDo?: string;
  dateNoUse?: string;
}
