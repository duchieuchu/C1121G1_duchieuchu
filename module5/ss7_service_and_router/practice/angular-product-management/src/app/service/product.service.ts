import {Injectable} from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor() {
  }

  getAll() {
    return this.products;
  }

  saveProduct(product) {
    this.products.push(product);
  }

  findById(id: number) {
    let productNeedFind: Product;
    for (let product of this.products) {
      if (product.id === id) {
        productNeedFind = product;
      }
    }
    return productNeedFind;
  }

  edit(value: Product) {
    console.log(value);
    for (let i = 0; i < this.products.length; i++) {
      console.log(this.products[i]);
      if (this.products[i].id === value.id) {
        this.products[i] = value;
        console.log(this.products[i]);
      }
    }
  }

  delete(id: number) {
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        for (let j = i; j < this.products.length; j++) {
          this.products[j] = this.products[j + 1];
        }
        this.products.pop();
      }
    }
  }
}
