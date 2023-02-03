import {Employee} from './employee';

export interface Base {
  id?: number;
  address?: string;
  name?: string;
  openDay?: string;
  baseCode?: string;
  employee?: Employee;
  isDeleted?: boolean;
}
