import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductBlock} from '../model/product-block';

@Injectable({
  providedIn: 'root'
})
export class ProductBlockService {
  product: ProductBlock [] = [];
  // private URL_PRODUCT_BLOCK = 'http://localhost:3000/product-block';
  private URL_PRODUCT_BLOCK = 'http://localhost:8080/rest/product-block';


  constructor(private httpClient: HttpClient) {
  }

  getAllProductBlock(): Observable<ProductBlock[]> {
    return this.httpClient.get<ProductBlock[]>(this.URL_PRODUCT_BLOCK);
  }

  getAllProductBlockByName(name: string): Observable<ProductBlock[]> {
    return this.httpClient.get<ProductBlock[]>(this.URL_PRODUCT_BLOCK + '?dateNoUse_like=' + name);
  }

  saveProductBlock(productBlock: ProductBlock) {
    return this.httpClient.post<ProductBlock>(this.URL_PRODUCT_BLOCK + '/create', productBlock);
  }

  delete(id: number): Observable<ProductBlock> {
    return this.httpClient.delete<ProductBlock>(this.URL_PRODUCT_BLOCK +"/delete"+ '/' + id);
  }
}
