import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  product: Product [] = [];
  // private URL_PRODUCT = 'http://localhost:3000/product';
  private URL_PRODUCT = 'http://localhost:8080/rest/product';

  constructor(private httpClient: HttpClient) {
  }
  // getAll(): Observable<Product[]> {
  //   return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  // }
  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/list');
  }
}
