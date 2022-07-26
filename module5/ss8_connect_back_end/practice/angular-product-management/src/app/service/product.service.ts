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

  deleteProduct(id: number) {
    return this.httpClient.delete<Product>(this.URL_PRODUCTS + '/' + id);
  }

  findById(id: number) {
    return this.httpClient.get<Product>(this.URL_PRODUCTS + '/' + id);
  }

  editProduct(id: number, product: Product) {
    return this.httpClient.patch<Product>(this.URL_PRODUCTS + '/' + id, product);
  }
}

