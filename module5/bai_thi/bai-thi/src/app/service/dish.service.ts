import {Injectable} from '@angular/core';
import {Dish} from '../model/dish';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductBlock} from '../model/product-block';

@Injectable({
  providedIn: 'root'
})
export class DishService {
  dish: Dish[] = [];
  private URL_DISH = 'http://localhost:8080/dish';

  constructor(private httpClient: HttpClient) {
  }

  getDishPage(): Observable<ProductBlock[]> {
    return this.httpClient.get<ProductBlock[]>(this.URL_DISH);
  }

  getDishPageByName(name: string): Observable<ProductBlock[]> {
    return this.httpClient.get<ProductBlock[]>(this.URL_DISH + '?dateNoUse_like=' + name);
  }
}
