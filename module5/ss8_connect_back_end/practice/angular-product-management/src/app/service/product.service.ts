import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];
  private URL_PRODUCTS = 'http://localhost:3000/product';

  constructor(private httpClient: HttpClient) {
    this.products.push({id: 1, name: 'iphone 12', price: 240000, description: 'New'});
  }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCTS);
  }

  saveProduct(product: Product) {
    return this.httpClient.post(this.URL_PRODUCTS, product);
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

