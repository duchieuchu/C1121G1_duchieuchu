import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = 'http://localhost:8080/product';
  private URL_CATEGORY = 'http://localhost:8080/category';

  constructor(private httpClient: HttpClient) {
  }

  getAllProduct(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.URL_PRODUCT+"/getAllProduct");
  }

  getAllCategory(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.URL_CATEGORY+"/getAllCategory");
  }

  deleteProductById(id: number): Observable<Product> {
    // @ts-ignore
    return this.httpClient.patch<Dish>(this.URL_PRODUCT + "/delete/" + id)
  }

  saveProduct(product: Product) {
    return this.httpClient.post<Product>(this.URL_PRODUCT + '/create', product);
  }


}
