import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = 'http://localhost:8080/product';

  constructor(private httpClient: HttpClient) {
  }

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post(this.URL_PRODUCT + '/createProduct', product);
  }

  editProduct(product: Product): Observable<Product> {
    return this.httpClient.patch(this.URL_PRODUCT + '/editProduct', product);
  }

  getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_PRODUCT + '/getProductId' + `/${id}`);
  }

  deleteProduct(id: number): Observable<Product> {
    // @ts-ignore
    return this.httpClient.patch<Product>(this.URL_PRODUCT + `/deleteProductById/${id}`);
  }

  getProductPage(page: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/getPageProduct?page=' + page);
  }


}
